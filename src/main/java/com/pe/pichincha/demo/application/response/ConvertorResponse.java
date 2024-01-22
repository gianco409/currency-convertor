package com.pe.pichincha.demo.application.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertorResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double currencyExchange;

	public ConvertorResponse(Double currencyExchange) {
		this.currencyExchange = currencyExchange;
	}
}
