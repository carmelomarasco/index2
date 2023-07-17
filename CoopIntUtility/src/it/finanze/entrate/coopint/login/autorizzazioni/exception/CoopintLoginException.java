package it.finanze.entrate.coopint.login.autorizzazioni.exception;

import java.io.Serializable;

public class CoopintLoginException extends Exception implements Serializable{
	
	private static final long serialVersionUID = 1234452394453932519L;
	
	public CoopintLoginException() {
	}

	public CoopintLoginException(String s) {
		super(s);
	}
	public String getMessage(){
		return super.getMessage();
	}
}
