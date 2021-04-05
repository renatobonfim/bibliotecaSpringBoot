package com.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{
		
}
