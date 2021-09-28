package com.molina.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.molina.bookstore.domain.Categoria;
import com.molina.bookstore.domain.Livro;
import com.molina.bookstore.repositories.CategoriaRepository;
import com.molina.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1)); // addAll caso tenha mais de um livro categoria informática

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));// livro reconhecendo sua categoria
	}

}
