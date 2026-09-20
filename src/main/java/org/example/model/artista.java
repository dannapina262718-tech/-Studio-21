package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artista")
public class artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String generoMusical;

    public artista() {
    }

    public artista(String generoMusical, String nombre) {
        this.generoMusical = generoMusical;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return "artista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                '}';
    }
}