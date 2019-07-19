package com.gabrielperuchi.workshopmongo.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielperuchi.workshopmongo.domain.Postagem;
import com.gabrielperuchi.workshopmongo.resource.util.URL;
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

	@RequestMapping(value = "/procuraTitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Postagem>> buscaPorTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {

		texto = URL.decodeParam(texto);
		
		List<Postagem> postagens = servico.buscaPorTitulo(texto);

		return ResponseEntity.ok().body(postagens);

	}
	
	@RequestMapping(value = "/buscaPersonalizada", method = RequestMethod.GET)
	public ResponseEntity<List<Postagem>> buscaPersonalizada(
			@RequestParam(value = "texto", defaultValue = "") String texto, 
			@RequestParam(value = "dataMin", defaultValue = "") String dataMin,
			@RequestParam(value = "dataMax", defaultValue = "") String dataMax
				){

		texto = URL.decodeParam(texto);
		
		Date min = URL.convertData(dataMin, new Date(0L));
		Date max = URL.convertData(dataMax, new Date());
		
		List<Postagem> postagens = servico.buscaPersonalizada(texto, min, max);

		return ResponseEntity.ok().body(postagens);

	}
	
}
