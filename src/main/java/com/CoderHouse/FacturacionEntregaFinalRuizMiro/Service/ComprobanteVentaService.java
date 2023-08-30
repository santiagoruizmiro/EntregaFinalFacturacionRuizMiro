package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.*;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ClienteRepository;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ProductoRepository;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ComprobanteVentaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprobanteVentaService {

    @Autowired
    private ComprobanteVentaRepository comprobanteVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Venta agregarProductoAVenta(Long ventaId, Long productoId, int cantidad) {
        Venta venta = comprobanteVentaRepository.findById(ventaId)
                .orElseThrow(() -> new EntityNotFoundException("Venta no encontrada"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        if (producto.getPr_Stock() >= cantidad) {
            venta.agregarDetalleVenta(producto, cantidad);
            producto.setPr_Stock(producto.getPr_Stock() - cantidad); // Actualizar el stock del producto

            comprobanteVentaRepository.save(venta);
            productoRepository.save(producto);

            return venta;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible para el producto");
        }

    }

    @Transactional
    public Venta generarComprobante(Long clientId, Long productoId, int cantidad) {
        Cliente cliente = clienteRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        Venta venta = new Venta();
        venta.obtenerFechaActualDesdeServicioExterno();
        venta.setCliente(cliente);

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        if (producto.getPr_Stock() >= cantidad) {
            venta.agregarDetalleVenta(producto, cantidad);
            producto.setPr_Stock(producto.getPr_Stock() - cantidad); // Actualizar el stock del producto
            comprobanteVentaRepository.save(venta);
            productoRepository.save(producto);
            // Guardar la venta en la base de datos
            Venta ventaGuardada = comprobanteVentaRepository.save(venta);
            return ventaGuardada;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible para el producto");
        }

    }

    @Transactional
    public List<Venta> generarComprobantes(List<ComprobanteRequest> comprobantes) {
        List<Venta> ventas = new ArrayList<>();

        for (ComprobanteRequest comprobante : comprobantes) {
            Cliente cliente = clienteRepository.findById(comprobante.getCliente().getClienteId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
            int cantidadTotalProductos = 0;
            double importeTotalVenta = 0.0;
            Venta venta = new Venta();
            venta.obtenerFechaActualDesdeServicioExterno();
            venta.setCliente(cliente);

            for (DetalleVentaRequest detalleRequest : comprobante.getDetalles()) {
                Producto producto = productoRepository.findById(detalleRequest.getProducto().getProductoId())
                        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

                int cantidad = detalleRequest.getCantidad();
                cantidadTotalProductos += cantidad;
                double importeDetalle = producto.getPr_Precio() * cantidad;
                importeTotalVenta += importeDetalle;
                if (producto.getPr_Stock() >= cantidad) {
                    DetalleVenta detalleVenta = new DetalleVenta(venta, producto, cantidad);
                    detalleVenta.setPr_Caracteristicas(producto.getPr_Caracteristicas());
                    detalleVenta.setPr_Precio(producto.getPr_Precio());
                    detalleVenta.setImporteTotal(producto.getPr_Precio() * cantidad);
                    venta.getDetallesVenta().add(detalleVenta);
                    producto.setPr_Stock(producto.getPr_Stock() - cantidad);
                } else {
                    throw new IllegalArgumentException("No hay suficiente stock disponible para el producto");
                }
            }

            venta.setCantidadTotalProductos(cantidadTotalProductos);
            venta.setImporteTotal(importeTotalVenta);
            comprobanteVentaRepository.save(venta);
            ventas.add(venta);
        }

        return ventas;
    }









}






