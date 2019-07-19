package com.gabrielperuchi.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielperuchi.workshopmongo.domain.Postagem;

@Repository
public interface PostagemRepositorio extends MongoRepository<Postagem, String> {

	List<Postagem> findByTituloContainingIgnoreCase(String texto);
	
}
