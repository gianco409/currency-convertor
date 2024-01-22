package com.pe.pichincha.demo.domain.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String email;
	private String password;
	private Boolean active;

	public Boolean isActive() {
		return active;
	}
}
