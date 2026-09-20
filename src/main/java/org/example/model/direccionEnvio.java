package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class direccionEnvio {
    @Column(nullable = false, length = 100)
    private String destinatario;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(nullable = false, length = 150)
    private String calle;

    @Column(nullable = false, length = 20)
    private String numeroExterior;

    @Column(nullable = false, length = 100)
    private String colonia;

    @Column(nullable = false, length = 100)
    private String ciudad;

    // Se llama "estado_direccion" para no chocar con la columna "estado" de pedido
    @Column(name = "estado_direccion", nullable = false, length = 100)
    private String estado;

    @Column(nullable = false, length = 10)
    private String codigoPostal;

    public direccionEnvio() {
    }

    public direccionEnvio(String destinatario, String telefono, String calle, String numeroExterior, String colonia, String ciudad, String estado, String codigoPostal) {
        this.destinatario = destinatario;
        this.telefono = telefono;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCalle() {
        return calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "direccionEnvio{" +
                "destinatario='" + destinatario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", calle='" + calle + '\'' +
                ", numeroExterior='" + numeroExterior + '\'' +
                ", colonia='" + colonia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }
}