package com.sigap.SIGAP.representante_legal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity //esto es una eintidad en la base de datos
@Table(name = "representantelegal")
@Data
@RequiredArgsConstructor
public class RepresentanteLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 1L;

    @JsonProperty("tipo_identificacion")
    @Column(length = 2, nullable = false)
    private String tipoIdentificacion;

    @JsonProperty("numero_identificacion")
    @Column(length = 16, nullable = false, unique = true)
    private String numeroIdentificacion;

    @JsonProperty("primer_apellido")
    @Column(length = 60, nullable = false)
    private String primerApeliido;

    @JsonProperty("segundo_apellido")
    @Column(length = 60)
    private String segundoApeliido;

    @JsonProperty("primer_nombre")
    @Column(length = 60, nullable = false)
    private String primerNombre;

    @JsonProperty("segundo_nombre")
    @Column(length = 60)
    private String segundoNombre;


    @JsonProperty("codigo_municipio")
    @Column(length = 5, nullable = false)
    private String codigoMunicipio;

    @JsonProperty("telefono")
    @Column(length = 22, nullable = false)
    private String telefono;

    @JsonProperty("direccion")
    @Column(length = 200, nullable = false)
    private String direccion;

    @JsonProperty("email")
    @Column(length = 80,nullable = false)
    private String email;
    @PrePersist
    private void prePersist() {

        id= 1L;
    }


}
