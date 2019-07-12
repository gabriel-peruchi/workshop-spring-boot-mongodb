package com.gabrielperuchi.workshopmongo.resource.exception;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;

	public ErroPadrao() {

	}

	public ErroPadrao(Long timestamp, Integer status, String erro, String mensagem, String caminho) {
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
