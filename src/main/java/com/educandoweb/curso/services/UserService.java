package com.educandoweb.curso.services;

import com.educandoweb.curso.modelo.User;
import com.educandoweb.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }
}
