package com.pe.pichincha.demo.infrastructure.repository.mapper;

import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.CurrencyDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.Currency;

@Component
public class CurrencyMapper implements ICurrencyMapper {

	@Override
	public CurrencyDTO entityToDto(Currency entity) {
		if (entity == null)
			return null;
		CurrencyDTO dto = new CurrencyDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSymbol(entity.getSymbol());
		dto.setBase(entity.getBase());
		dto.setAmount(entity.getAmount());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());
		return dto;
	}

	@Override
	public Currency dtoToEntity(CurrencyDTO dto) {
		if (dto == null)
			return null;
		Currency entity = new Currency();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSymbol(dto.getSymbol());
		entity.setBase(dto.getBase());
		entity.setAmount(dto.getAmount());
		entity.setCreatedAt(dto.getCreatedAt());
		entity.setUpdatedAt(dto.getUpdatedAt());
		return entity;
	}
}
