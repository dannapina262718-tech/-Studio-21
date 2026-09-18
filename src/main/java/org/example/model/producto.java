package org.example.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "artista")
    private artista artista;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<imagenProducto> imagenes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public artista getArtista() {
        return artista;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public List<imagenProducto> getImagenes() {
        return imagenes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setArtista(artista artista) {
        this.artista = artista;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public void setImagenes(List<imagenProducto> imagenes) {
        this.imagenes = imagenes;
    }

    public void agregarImagen(imagenProducto imagen) {
        imagenes.add(imagen);
        imagen.setProducto(this);
    }

    @Override
    public String toString() {
        return "producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", activo=" + activo +
                ", artista=" + artista +
                ", categoria=" + categoria +
                '}';
    }
}
