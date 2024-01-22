package com.pe.pichincha.demo.domain.service;

import com.pe.pichincha.demo.application.request.ConvertorRequest;

public interface ICurrencyConverterService {
	Double convert(ConvertorRequest convertorRequest);
}
