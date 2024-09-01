package com.sigap.SIGAP.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity //esto es una eintidad en la base de datos
@Table(name="empresas")
//@Data //genera todo los get set
@Getter
@Setter
@Data
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="tipoRegistro",length = 1,nullable = false)
    private int tipoRegistro;

    @Column(name="tipoIdentificacion",length = 2,nullable = false)
    private String tipoIdentificacion;

    @Column(name="razonSocial",length = 200,nullable = false)
    private String razonSocial;

    @Column(name="nNit",length = 12,nullable = false)
    private int nNit;

    @Column(name="nNit",length = 1,nullable = false)
    private int dv;

    @Column(name="tipoEntidad",length = 1,nullable = false)
    private int tipoEntidad;

    @Column(name="codMunicipio",length = 5,nullable = false)
    private String codMunicipio;

    @Column(name="actEconomica",length = 4,nullable = false)
    private int actEconomica;

    @Column(name="telefono",length = 22,nullable = false)
    private String telefono;

    @Column(name="direccion",length = 200,nullable = false)
    private String direccion;

    @Column(name="direccion",length = 101,nullable = false)
    private String email;


    public Empresa(){

    }
    public Empresa(Long id, int tipoRegistro, String tipoIdentificacion, String razonSocial, int nNit, int dv, int tipoEntidad, String codMunicipio, int actEconomica, String telefono, String direccion, String email) {
        this.id = id;
        this.tipoRegistro = tipoRegistro;
        this.tipoIdentificacion = tipoIdentificacion;
        this.razonSocial = razonSocial;
        this.nNit = nNit;
        this.dv = dv;
        this.tipoEntidad = tipoEntidad;
        this.codMunicipio = codMunicipio;
        this.actEconomica = actEconomica;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getnNit() {
        return nNit;
    }

    public void setnNit(int nNit) {
        this.nNit = nNit;
    }

    public int getDv() {
        return dv;
    }

    public void setDv(int dv) {
        this.dv = dv;
    }

    public int getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(int tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public int getActEconomica() {
        return actEconomica;
    }

    public void setActEconomica(int actEconomica) {
        this.actEconomica = actEconomica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
