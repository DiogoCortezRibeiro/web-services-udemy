package com.educandoweb.curso.services;

import com.educandoweb.curso.modelo.Categoria;
import com.educandoweb.curso.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
