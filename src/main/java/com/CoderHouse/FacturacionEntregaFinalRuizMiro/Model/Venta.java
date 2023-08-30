package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Venta() {
    }

    private String fecha;

    @ManyToOne
    private Cliente cliente;


    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleVenta> detallesVenta=new ArrayList<>();

    private int cantidadTotalProductos;

    private Double importeTotal;

    public void agregarDetalleVenta(DetalleVenta detalleVenta) {
        detallesVenta.add(detalleVenta);
    }

    public Venta(Long id, String fecha, Cliente cliente, List<DetalleVenta> detallesVenta) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detallesVenta = detallesVenta;
    }

    public void agregarDetalleVenta(Producto producto, int cantidadVendida) {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCliente(cliente);
        detalleVenta.setVenta(this); // Establece la relación con la venta actual
        detalleVenta.setProducto(producto);
        detalleVenta.setCantidadVendida(cantidadVendida);
        detalleVenta.setPr_Precio(producto.getPr_Precio());
        detalleVenta.setImporteTotal(producto.getPr_Precio() * cantidadVendida);
        detalleVenta.setPr_Caracteristicas(producto.getPr_Caracteristicas());
        detallesVenta.add(detalleVenta);
    }
    public void obtenerFechaActualDesdeServicioExterno() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://worldclockapi.com/api/json/utc/now";
        try {
            WorldClockResponse response = restTemplate.getForObject(url, WorldClockResponse.class);
            if (response != null && response.getCurrentDateTime() != null) {
                this.fecha = response.getCurrentDateTime();
            }
        } catch (Exception e) {
            // Manejo de error, por ejemplo, establecer la fecha actual de Java si el servicio falla
            this.fecha = String.valueOf(new Date());
        }
    }
}