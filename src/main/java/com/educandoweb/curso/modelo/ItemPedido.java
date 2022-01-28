package com.educandoweb.curso.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {}

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
    }

    @JsonIgnore
    public Pedido getPedido()
    {
        return this.id.getPedido();
    }

    public void setPedido(Pedido pedido)
    {
        this.id.setPedido(pedido);
    }

    @JsonIgnore
    public Produto getProduto()
    {
        return this.id.getProduto();
    }

    public void setPedido(Produto produto)
    {
        this.id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
