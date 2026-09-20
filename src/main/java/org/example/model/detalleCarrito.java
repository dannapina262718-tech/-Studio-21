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

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto", nullable = false)
    private producto producto;

    @Column
    private int cantidad;

    public detalleCarrito() {
    }

    public detalleCarrito(int cantidad, producto producto, carrito carrito) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.carrito = carrito;
    }

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