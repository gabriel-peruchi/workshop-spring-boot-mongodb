package com.gabrielperuchi.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.services.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServico servico;

	@GetMapping
	public ResponseEntity<List<Usuario>> buscaTodos() {

		List<Usuario> lista = servico.buscaTodos();

		return ResponseEntity.ok().body(lista);
	}

}
