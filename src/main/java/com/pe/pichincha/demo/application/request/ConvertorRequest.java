package com.pe.pichincha.demo.application.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertorRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String symbolFrom;
	private String symbolTo;
	private Double amountFrom;

}
