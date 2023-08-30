package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Table
@Entity
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name="cliente_id")
    @JsonBackReference
    private  Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    @JsonBackReference
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonBackReference
    private Producto producto;

    @JoinColumn(name = "pr_Caracteristicas")
    @JsonBackReference
    private String pr_Caracteristicas;



    @Column (name="cantidadVendida")
    private int cantidadVendida;

    @JoinColumn(name = "pr_Precio")
    private Double pr_Precio;

    @Column (name="importeTotal")
    private double importeTotal;

    private void agregarProducto (Producto producto, Venta venta, int cantidadVendida){

    }



    public DetalleVenta(Venta venta, Producto producto, int cantidadVendida) {
        this.venta = venta;
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    public DetalleVenta() {

    }
}