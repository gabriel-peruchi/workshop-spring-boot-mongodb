package com.gabrielperuchi.workshopmongo.dto;

import java.io.Serializable;

import com.gabrielperuchi.workshopmongo.domain.Usuario;

//Objeto criado a partir do usuario para melhorar o tráfego na rede (com filtro de campos)
public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public AutorDTO() {

	}

	public AutorDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
