package com.gabrielperuchi.workshopmongo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielperuchi.workshopmongo.domain.Postagem;
import com.gabrielperuchi.workshopmongo.services.PostagemServico;

@RestController
@RequestMapping(value = "/postagem")
public class PostagemResource {

	@Autowired
	private PostagemServico servico;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Postagem> buscaPorId(@PathVariable String id) {

		Postagem postagem = servico.buscaPorId(id);

		return ResponseEntity.ok().body(postagem);

	}

}
