package com.example.bootsecurityjwtc51.configuration.jwt;

import javax.naming.AuthenticationException;

public class JWTAuthenticationException extends AuthenticationException {

	public JWTAuthenticationException(String msg) {
		super(msg);
	}
}
