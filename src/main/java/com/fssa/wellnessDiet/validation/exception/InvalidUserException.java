package com.fssa.wellnessdiet.validation.exception;

public class InvalidUserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6002586833424238250L;
	public InvalidUserException(String msg) {
		super(msg);
	}
	public InvalidUserException(Throwable e) {
		super(e); 
	}
	

}
