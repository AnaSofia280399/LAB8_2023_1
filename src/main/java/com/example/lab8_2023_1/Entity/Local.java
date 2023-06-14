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
    private String direccion;

    @Column(name = "latitud", length = 45)
    private String latitud;

    @Column(name = "longitud", length = 45)
    private String longitud;

    @OneToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private Empresa idEmpresa;


}
