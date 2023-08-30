package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

public class DetalleVentaRequest {
    private ProductoRequest producto;
    private int cantidad;

    public ProductoRequest getProducto() {
        return producto;
    }

    public void setProducto(ProductoRequest producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public DetalleVentaRequest(ProductoRequest producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
