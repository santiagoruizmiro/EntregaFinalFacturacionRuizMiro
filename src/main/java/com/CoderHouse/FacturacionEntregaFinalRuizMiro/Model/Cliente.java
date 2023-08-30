package com.CoderHouse.FacturacionEntregaFinalRuizMiro.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;



    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellido, int dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Column(name = "DNI")
    private int dni;

}