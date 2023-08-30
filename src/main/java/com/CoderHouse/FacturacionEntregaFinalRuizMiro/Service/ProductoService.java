package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Producto;
import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements iProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public List<Producto> getProductos() {
        List<Producto>productosList=productoRepository.findAll();
        return productosList;
    }

    @Override
    @Transactional
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
}

    @Override
    public Producto findProducto(Long id) {
        Producto producto=productoRepository.getById(id);
        return producto;
    }

    @Transactional
    @Override
    public Producto modificarprecio(Long id, double producto_precio){
        Producto producto=productoRepository.getById(id);
        producto.setPr_Precio(producto_precio);
        productoRepository.save(producto);
        return producto;
    }
}

