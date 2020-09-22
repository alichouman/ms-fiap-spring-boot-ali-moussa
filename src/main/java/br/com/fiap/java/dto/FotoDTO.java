package br.com.fiap.java.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@ApiModel(value = "CozinhaDTO", description = "Objeto de transferencia de dados")
public class FotoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(dataType = "String", name = "baseFotoDTO", value = "Base 64 de transferencia de dados para foto")
	private String baseFotoDTO;

	@ApiModelProperty(dataType = "Integer", name = "cozinhaId", value = "Codigo de transferencia de dados para cozinha")
	private Integer cozinhaId;
	
	public FotoDTO() {
	}

	public String getBaseFotoDTO() {
		return baseFotoDTO;
	}

	public void setBaseFotoDTO(String baseFotoDTO) {
		this.baseFotoDTO = baseFotoDTO;
	}

	public Integer getCozinhaId() {
		return cozinhaId;
	}

	public void setCozinhaId(Integer cozinhaId) {
		this.cozinhaId = cozinhaId;
	}
	
	



}
