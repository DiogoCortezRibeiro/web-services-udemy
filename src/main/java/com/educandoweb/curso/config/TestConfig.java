package com.educandoweb.curso.config;

import com.educandoweb.curso.modelo.Categoria;
import com.educandoweb.curso.modelo.Pedido;
import com.educandoweb.curso.modelo.Produto;
import com.educandoweb.curso.modelo.User;
import com.educandoweb.curso.repository.CategoriaRepository;
import com.educandoweb.curso.repository.PedidoRepository;
import com.educandoweb.curso.repository.ProdutoRepository;
import com.educandoweb.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Eletronicos");
        Categoria cat2 = new Categoria( "Livros");
        Categoria cat3 = new Categoria("Computadores");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Produto prod1 = new Produto("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto prod2 = new Produto("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto prod3 = new Produto("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto prod4 = new Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto prod5 = new Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

        Pedido p1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), u1);
        Pedido p2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), u2);
        Pedido p3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), u1);

        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
