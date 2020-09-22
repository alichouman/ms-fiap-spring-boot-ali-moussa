package br.com.fiap.java.exception;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
