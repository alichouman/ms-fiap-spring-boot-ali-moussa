package br.com.fiap.java.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@Entity
@ApiModel(value = "Foto", description = "Informacoes da Foto")
public class Foto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(dataType = "Integer", name = "id", value = "Código de identificação da foto", example = "10")
	private Integer id;

	@Column(nullable = false)
	@ApiModelProperty(dataType = "String", name = "baseFoto", value = "Base 64 da foto", example = "data:image/jpeg;base64,FOTO_EM_BASE_64")
	private String baseFoto;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;

	public Foto() {
	}

	public Foto(Integer id, String baseFoto) {
		this.id = id;
		this.baseFoto = baseFoto;
	}

	public Foto(Integer id, String baseFoto, Cozinha cozinha) {
		this.id = id;
		this.baseFoto = baseFoto;
		this.cozinha = cozinha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBaseFoto() {
		return baseFoto;
	}

	public void setBaseFoto(String baseFoto) {
		this.baseFoto = baseFoto;
	}

	public Cozinha getCozinha() {
		return cozinha;
	}

	public void setCozinha(Cozinha cozinha) {
		this.cozinha = cozinha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foto other = (Foto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
