package br.com.fiap.java.dto;

import java.io.Serializable;

import br.com.fiap.java.model.Cozinha;

public class FotoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String baseFotoDTO;

	private Cozinha cozinha;

	public FotoDTO() {
	}

	public String getBaseFotoDTO() {
		return baseFotoDTO;
	}

	public void setBaseFotoDTO(String baseFotoDTO) {
		this.baseFotoDTO = baseFotoDTO;
	}

	public Cozinha getCozinha() {
		return cozinha;
	}

	public void setCozinha(Cozinha cozinha) {
		this.cozinha = cozinha;
	}

}
