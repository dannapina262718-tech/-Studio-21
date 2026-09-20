package org.example.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrito")
public class carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<detalleCarrito> detalles = new ArrayList<>();

    public carrito() {
    }

    public carrito(List<detalleCarrito> detalles, usuario usuario) {
        this.detalles = detalles;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public List<detalleCarrito> getDetalles() {
        return detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public void setDetalles(List<detalleCarrito> nuevosDetalles) {
        List<detalleCarrito> copia = new ArrayList<>(nuevosDetalles);

        for (detalleCarrito anterior : this.detalles) {
            anterior.setCarrito(null);
        }

        this.detalles.clear();

        for (detalleCarrito detalle : copia) {
            agregarDetalle(detalle);
        }
    }

    public void agregarDetalle(detalleCarrito detalle) {
        detalles.add(detalle);
        detalle.setCarrito(this);
    }

    @Override
    public String toString() {
        return "carrito{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", detalles=" + detalles +
                '}';
    }
}
