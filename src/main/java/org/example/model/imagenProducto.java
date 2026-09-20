package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenProducto")
public class imagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String url;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private producto producto;

    public imagenProducto() {
    }

    public imagenProducto(producto producto, String url) {
        this.producto = producto;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public producto getProducto() {
        return producto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }


}