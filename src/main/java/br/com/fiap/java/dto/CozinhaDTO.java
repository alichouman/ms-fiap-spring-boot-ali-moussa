package br.com.fiap.java.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@ApiModel(value = "CozinhaDTO", description = "Objeto de transferencia de dados")
public class CozinhaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(dataType = "String", name = "nome", value = "Nome de transferencia de dados para cozinha", example = "McDonald's")
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
