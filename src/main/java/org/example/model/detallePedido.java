package org.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detallePedido")
public class detallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitarioCompra;

    public Long getId() {
        return id;
    }

    public pedido getPedido() {
        return pedido;
    }

    public producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnitarioCompra() {
        return precioUnitarioCompra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPedido(pedido pedido) {
        this.pedido = pedido;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitarioCompra(BigDecimal precioUnitarioCompra) {
        this.precioUnitarioCompra = precioUnitarioCompra;
    }

    @Override
    public String toString() {
        return "detallePedido{" +
                "id=" + id +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioUnitarioCompra=" + precioUnitarioCompra +
                '}';
    }
}