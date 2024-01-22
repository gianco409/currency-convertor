package com.pe.pichincha.demo.domain.service;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;

public interface ICurrencyService {
	void addCurrency(CurrencyDTO currencyDTO);
	void updateCurrency(CurrencyDTO currencyDTO);
	CurrencyDTO getCurrency(Long id);
}
