package br.com.fiap.java.exception;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
