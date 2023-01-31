package com.acastillo.dev.test.application.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException (String message) {
		super (message);
	}
}
