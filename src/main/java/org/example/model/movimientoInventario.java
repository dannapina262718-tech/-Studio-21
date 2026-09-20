package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientoInventario")
public class movimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private int cambioCantidad;

    @Column(nullable = false, length = 200)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private producto producto;

    @ManyToOne
    @JoinColumn(name = "registrado_por", nullable = false)
    private usuario registradoPor;

    public movimientoInventario() {
    }

    public movimientoInventario(usuario registradoPor, producto producto, String motivo, int cambioCantidad, LocalDateTime fecha) {
        this.registradoPor = registradoPor;
        this.producto = producto;
        this.motivo = motivo;
        this.cambioCantidad = cambioCantidad;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getCambioCantidad() {
        return cambioCantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public producto getProducto() {
        return producto;
    }

    public usuario getRegistradoPor() {
        return registradoPor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setCambioCantidad(int cambioCantidad) {
        this.cambioCantidad = cambioCantidad;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public void setRegistradoPor(usuario registradoPor) {
        this.registradoPor = registradoPor;
    }

    @Override
    public String toString() {
        return "movimientoInventario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cambioCantidad=" + cambioCantidad +
                ", motivo='" + motivo + '\'' +
                ", producto=" + producto +
                ", registradoPor=" + registradoPor +
                '}';
    }
}