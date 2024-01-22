package com.pe.pichincha.demo.infrastructure.repository.mapper;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.Currency;

public interface ICurrencyMapper {
	CurrencyDTO entityToDto(Currency entity);
	Currency dtoToEntity(CurrencyDTO dto);
}
