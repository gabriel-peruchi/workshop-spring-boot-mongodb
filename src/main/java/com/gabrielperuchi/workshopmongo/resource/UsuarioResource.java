package com.gabrielperuchi.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielperuchi.workshopmongo.domain.Usuario;

@RestController 
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<List<Usuario>> buscaTodos() {

		Usuario gabriel = new Usuario("1", "Gabriel Peruchi", "gabriel@gmail.com");
		Usuario carlos = new Usuario("2", "Carlos Alberto", "carlos@gmail.com");

		List<Usuario> lista = new ArrayList<Usuario>();
		lista.addAll((Arrays.asList(gabriel, carlos)));

		return ResponseEntity.ok().body(lista);
	}

}
