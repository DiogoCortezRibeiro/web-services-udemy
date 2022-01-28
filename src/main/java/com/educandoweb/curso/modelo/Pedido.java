package com.educandoweb.curso.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    @Enumerated(EnumType.STRING)
    private PedidosStatus pedidosStatus = PedidosStatus.AGUARDANDO_PAGAMENTO;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private User cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> items = new HashSet<>();

    public Pedido() {}

    public Pedido(Instant momento, User cliente) {
        this.momento = momento;
        this.cliente = cliente;
    }

    public Instant getMomento() {
        return momento;
    }

    public User getCliente() {
        return cliente;
    }

    public PedidosStatus getPedidosStatus() { return pedidosStatus; }

    public void setPedidosStatus(PedidosStatus pedidosStatus) { this.pedidosStatus = pedidosStatus; }

    public Set<ItemPedido> getItems()
    {
        return this.items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
