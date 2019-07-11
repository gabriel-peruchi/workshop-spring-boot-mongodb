package com.gabrielperuchi.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.repository.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio; // Esta anotação já instancia automaticamente

	public List<Usuario> buscaTodos() {

		return repositorio.findAll();
	}

}
