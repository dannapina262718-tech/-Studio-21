package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleCarrito")
public class detalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private carrito carrito;

    @ManyToOne
    @JoinColumn(name = "producto")
    private producto producto;

    @Column
    private int cantidad;

    public Long getId() {
        return id;
    }

    public carrito getCarrito() {
        return carrito;
    }

    public producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarrito(carrito carrito) {
        this.carrito = carrito;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "detalleCarrito{" +
                "id=" + id +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}