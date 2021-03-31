package com.biblioteca.locacaospringjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.locacaospringjpa.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
