package com.pe.pichincha.demo.application.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private String message;

	public ErrorResponse(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
