package com.pe.pichincha.demo.application.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String token;
	
	public AuthResponse(String token) {
		this.token = token;
	}
}
