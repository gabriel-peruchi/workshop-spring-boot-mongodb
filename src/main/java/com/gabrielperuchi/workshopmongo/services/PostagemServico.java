package com.gabrielperuchi.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielperuchi.workshopmongo.domain.Postagem;
import com.gabrielperuchi.workshopmongo.repository.PostagemRepositorio;
import com.gabrielperuchi.workshopmongo.services.exception.ObjetoNaoEncontradoException;

@Service
public class PostagemServico {

	@Autowired
	private PostagemRepositorio repositorio;

	public Postagem buscaPorId(String id) {

		Optional<Postagem> postagem = repositorio.findById(id);

		return postagem.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}

	public List<Postagem> buscaPorTitulo(String texto) {
		return repositorio.buscaPorTitulo(texto);
	}

	public List<Postagem> buscaPersonalizada(String texto, Date dataMin, Date dataMax) {

		dataMax = new Date(dataMax.getTime() + 24 * 60 * 60 * 1000);

		return repositorio.buscaPersonaliada(texto, dataMin, dataMax);

	}

}
