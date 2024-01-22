package com.pe.pichincha.demo.domain.repository;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;

public interface CurrencyRepository {
	void save(CurrencyDTO currency);
	void update(CurrencyDTO currency);
	CurrencyDTO getById(Long id);
	CurrencyDTO getBySymbolAndBase(String symbol, String base);
}
