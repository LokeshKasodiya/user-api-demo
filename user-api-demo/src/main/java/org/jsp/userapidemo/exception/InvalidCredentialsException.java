package org.jsp.userapidemo.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Credentials";
	}
}
