package com.pe.pichincha.demo.domain.service;

import org.springframework.stereotype.Service;

import com.pe.pichincha.demo.application.request.ConvertorRequest;
import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.domain.repository.CurrencyRepository;
import com.pe.pichincha.demo.domain.repository.OperationRepository;

@Service
public class CurrencyConverterService implements ICurrencyConverterService {

	public final CurrencyRepository currencyRepository;
	public final OperationRepository operationRepository;

	public CurrencyConverterService(CurrencyRepository currencyRepository, OperationRepository operationRepository) {
		this.currencyRepository = currencyRepository;
		this.operationRepository = operationRepository;
	}

	@Override
	public Double convert(ConvertorRequest convertorRequest) {
		CurrencyDTO currency = currencyRepository.getBySymbolAndBase(convertorRequest.getSymbolFrom(),
				convertorRequest.getSymbolTo());
		return convertorRequest.getAmountFrom() * currency.getAmount();
	}

}
