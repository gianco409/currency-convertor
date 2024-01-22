package com.pe.pichincha.demo.application.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthSignUp implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
}
