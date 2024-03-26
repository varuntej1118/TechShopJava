package com.exception;

public class InventoryNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message;
	public InventoryNotFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
