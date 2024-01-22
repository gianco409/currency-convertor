package com.pe.pichincha.demo.domain.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String symbol;
	private String base;
	private Double amount;
	private Date createdAt;
	private Date updatedAt;
}
