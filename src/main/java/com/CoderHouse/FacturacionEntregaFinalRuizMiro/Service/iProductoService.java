package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Service;

import com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model.Producto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface iProductoService {
    public List<Producto> getProductos();


    @Transactional
    void saveProducto(Producto producto);

    @Transactional
    public Producto findProducto(Long id);

    @Transactional
    Producto modificarprecio(Long id, double producto_precio);
}
