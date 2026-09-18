package org.example.model;

import jakarta.persistence.*;
import org.example.enums.estadoPedido;
import org.example.enums.metodoPago;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String numeroPedido;

    @Column(nullable = false)
    private LocalDateTime fechaCompra;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private estadoPedido estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private metodoPago metodoPago;

    @Embedded
    private direccionEnvio direccionEnvio;

    @Column
    private LocalDateTime fechaEnvio;

    @Column
    private LocalDateTime fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<detallePedido> detalles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public estadoPedido getEstado() {
        return estado;
    }

    public metodoPago getMetodoPago() {
        return metodoPago;
    }

    public direccionEnvio getDireccionEnvio() {
        return direccionEnvio;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public List<detallePedido> getDetalles() {
        return detalles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setEstado(estadoPedido estado) {
        this.estado = estado;
    }

    public void setMetodoPago(metodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setDireccionEnvio(direccionEnvio direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public void setDetalles(List<detallePedido> detalles) {
        this.detalles = detalles;
    }

    public void agregarDetalle(detallePedido detalle) {
        detalles.add(detalle);
        detalle.setPedido(this);
    }

    @Override
    public String toString() {
        return "pedido{" +
                "id=" + id +
                ", numeroPedido='" + numeroPedido + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", total=" + total +
                ", estado=" + estado +
                ", metodoPago=" + metodoPago +
                ", direccionEnvio=" + direccionEnvio +
                ", fechaEnvio=" + fechaEnvio +
                ", fechaEntrega=" + fechaEntrega +
                ", usuario=" + usuario +
                ", detalles=" + detalles +
                '}';
    }
}