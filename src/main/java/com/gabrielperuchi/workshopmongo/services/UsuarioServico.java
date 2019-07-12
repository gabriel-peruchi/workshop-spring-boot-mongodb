package com.gabrielperuchi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.repository.UsuarioRepositorio;
import com.gabrielperuchi.workshopmongo.services.exception.ObjetoNaoEncontradoException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio; // Esta anotação já instancia automaticamente

	public List<Usuario> buscaTodos() {

		return repositorio.findAll();
	}
	
	public Usuario buscaPorId(String id) {
		
		Optional<Usuario> usuario = repositorio.findById(id);
		
		return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
}
