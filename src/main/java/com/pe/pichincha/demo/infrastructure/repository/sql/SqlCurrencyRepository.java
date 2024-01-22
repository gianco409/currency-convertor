package com.pe.pichincha.demo.infrastructure.repository.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.domain.repository.CurrencyRepository;
import com.pe.pichincha.demo.infrastructure.repository.entity.Currency;
import com.pe.pichincha.demo.infrastructure.repository.mapper.ICurrencyMapper;

@Component
public class SqlCurrencyRepository implements CurrencyRepository {

	@Autowired
	private SpringDataCurrencyRepository springDataCurrencyRepository;

	@Autowired
	private ICurrencyMapper currencyMapper;

	@Override
	public void save(CurrencyDTO currency) {
		springDataCurrencyRepository.save(currencyMapper.dtoToEntity(currency));

	}

	@Override
	public void update(CurrencyDTO currency) {
		springDataCurrencyRepository.save(currencyMapper.dtoToEntity(currency));
	}

	@Override
	public CurrencyDTO getById(Long id) {
		Currency cyrrency = springDataCurrencyRepository.findById(id).orElse(null);
		return currencyMapper.entityToDto(cyrrency);
	}

	@Override
	public CurrencyDTO getBySymbolAndBase(String symbol, String base) {
		Currency currency = springDataCurrencyRepository.findBySymbolAndBase(symbol, base).orElse(null);
		return currencyMapper.entityToDto(currency);
	}

}
