package com.educandoweb.curso.services;

import com.educandoweb.curso.modelo.Pedido;
import com.educandoweb.curso.modelo.Produto;
import com.educandoweb.curso.repository.PedidoRepository;
import com.educandoweb.curso.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto findById(Long id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

}
