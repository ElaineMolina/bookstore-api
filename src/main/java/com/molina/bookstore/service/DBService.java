package com.molina.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.molina.bookstore.domain.Categoria;
import com.molina.bookstore.domain.Livro;
import com.molina.bookstore.repositories.CategoriaRepository;
import com.molina.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Religião", "Livros de Estudo Biblico");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");
		Categoria cat4 = new Categoria(null, "Ficção Científica", "Ficção Científiva");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gertner", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Lorem ipsum", cat4);
		Livro l4 = new Livro(null, "The War of the Worlds", "H. G. Wells", "Lorem ipsum", cat4);
		Livro l5 = new Livro(null, "O Poder da Mulher que Ora", "Storme Omartian", "Lorem ipsum", cat2);
		Livro l6 = new Livro(null, "Escatologia e a Vida de Santidade", "Edison Naves", "Lorem ipsum", cat2);
		Livro l7 = new Livro(null, "I, Robot", "Issac Asimov", "Lorem ipsum", cat4);

		cat1.getLivros().addAll(Arrays.asList(l1, l2)); // addAll caso tenha mais de um livro categoria informática
		cat2.getLivros().addAll(Arrays.asList(l5, l6));
		cat4.getLivros().addAll(Arrays.asList(l3, l4, l7));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));// livro reconhecendo sua categoria
	}

}
