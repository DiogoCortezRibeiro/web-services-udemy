package com.educandoweb.curso.repository;

import com.educandoweb.curso.modelo.ItemPedido;
import com.educandoweb.curso.modelo.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
}
