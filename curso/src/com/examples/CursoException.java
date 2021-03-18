package com.examples;

@SuppressWarnings("serial")
public class CursoException extends Exception {
//	private static final long serialVersionUID = 1L;

	public CursoException(String message) {
		super(message);
	}

	public CursoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CursoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
