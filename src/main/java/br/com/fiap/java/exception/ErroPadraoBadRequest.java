package br.com.fiap.java.exception;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

public class ErroPadraoBadRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "timestamp", example = "1600778638948")
	private Long timestamp;

	@ApiModelProperty(name = "status", example = "400")
	private Integer status;

	@ApiModelProperty(name = "error", example = "Integridade de dados")
	private String error;

	@ApiModelProperty(name = "message", example = "Não é possível excluir uma cozinha que possui fotos")
	private String message;

	@ApiModelProperty(name = "path", example = "/cozinhas/3")
	private String path;

	public ErroPadraoBadRequest(Long timestamp, Integer status, String error, String message, String path) {
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
