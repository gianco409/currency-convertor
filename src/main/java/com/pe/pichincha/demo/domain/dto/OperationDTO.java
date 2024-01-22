package com.pe.pichincha.demo.domain.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String symbolFrom;
	private String symbolTo;
	private Double amountFrom;
	private Double amountTo;
	private Date createdAt;
}
