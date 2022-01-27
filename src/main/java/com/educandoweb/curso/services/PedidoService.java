package com.educandoweb.curso.services;

import com.educandoweb.curso.modelo.Pedido;
import com.educandoweb.curso.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}
