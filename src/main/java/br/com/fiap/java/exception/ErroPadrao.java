package br.com.fiap.java.exception;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "timestamp", example = "1600777310606")
	private Long timestamp;

	@ApiModelProperty(name = "status", example = "404")
	private Integer status;

	@ApiModelProperty(name = "error", example = "Não encontrado")
	private String error;

	@ApiModelProperty(name = "message", example = "Objeto não encontrado! Id: 23, Tipo: br.com.fiap.java.model.Cozinha")
	private String message;

	@ApiModelProperty(name = "path", example = "/cozinhas/23")
	private String path;

	public ErroPadrao(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
