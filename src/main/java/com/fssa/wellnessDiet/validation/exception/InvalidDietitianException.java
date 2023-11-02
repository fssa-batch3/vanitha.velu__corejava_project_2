package com.fssa.wellnessdiet.validation.exception; 

public class InvalidDietitianException  extends Exception {
	
	private static final long serialVersionUID = 6002586833424238250L;
	
	public InvalidDietitianException(String msg) {
		super(msg);
	}
	public InvalidDietitianException(Throwable e) {
		super(e); 
	}
}
