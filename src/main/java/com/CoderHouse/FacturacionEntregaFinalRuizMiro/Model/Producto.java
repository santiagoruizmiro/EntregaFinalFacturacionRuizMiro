package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Producto() {
    }

    public Producto(int id, String pr_Nombre, String pr_Caracteristicas, int pr_Stock) {
        this.id = id;
        this.pr_Nombre = pr_Nombre;
        this.pr_Caracteristicas = pr_Caracteristicas;
        this.pr_Stock = pr_Stock;
    }

    @Column (name="pr_Nombre")
    private String pr_Nombre;


    @Column (name="pr_Caracteristicas")
    @JsonManagedReference
    private String pr_Caracteristicas;

    @Column(name="pr_Stock")
    private int pr_Stock;

    @Column (name = "pr_Precio")
    @JsonManagedReference
    private double pr_Precio;


    public double getPr_Precio() {
        return pr_Precio;
    }
}
