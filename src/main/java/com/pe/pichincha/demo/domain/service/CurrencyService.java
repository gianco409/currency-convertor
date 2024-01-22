package com.pe.pichincha.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.domain.repository.CurrencyRepository;

@Service
public class CurrencyService implements ICurrencyService {

	@Autowired
	public CurrencyRepository currencyRepository;

	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	@Override
	public void addCurrency(CurrencyDTO currencyDTO) {
		currencyRepository.save(currencyDTO);
	}

	@Override
	public void updateCurrency(CurrencyDTO currencyDTO) {
		currencyRepository.update(currencyDTO);
	}

	@Override
	public CurrencyDTO getCurrency(Long id) {
		return currencyRepository.getById(id);
	}

}
