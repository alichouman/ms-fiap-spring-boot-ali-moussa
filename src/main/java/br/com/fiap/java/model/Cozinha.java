package br.com.fiap.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@Entity
@ApiModel(value = "Cozinha", description = "Informacoes da Cozinha")
public class Cozinha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(dataType = "Integer", name = "id", value = "Código de identificação da Cozinha", example = "6")
	private Integer id;

	@Column(nullable = false)
	@ApiModelProperty(dataType = "String", name = "nome", value = "Nome da cozinha", example = "McDonald's")
	private String nome;

	@OneToMany(mappedBy = "cozinha")
	@ApiModelProperty(dataType = "List", name = "fotos", value = "Fotos relacionadas a cozinha")
	private List<Foto> fotos = new ArrayList<>();

	public Cozinha() {

	}

	public Cozinha(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
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
		Cozinha other = (Cozinha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
