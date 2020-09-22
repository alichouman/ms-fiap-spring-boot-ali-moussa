package br.com.fiap.java.dto;

import java.io.Serializable;

public class CozinhaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public CozinhaDTO() {
	}

	public CozinhaDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
