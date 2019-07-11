package com.gabrielperuchi.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielperuchi.workshopmongo.domain.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

}
