package com.example.lab8_2023_1.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "local")
@Setter
@Getter
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "direccion",  length = 45)
    private String nombre;

    @Column(name = "latitud", length = 45)
    private String apellido;

    @Column(name = "longitud", length = 45)
    private String correo;

    @OneToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private Empresa idEmpresa;


}
