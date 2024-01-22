package com.pe.pichincha.demo.infrastructure.repository.mapper;

import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.OperationDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.Operation;

@Component
public class OperationMapper implements IOperationMapper {

	@Override
	public OperationDTO entityToDto(Operation entity) {
		if (entity == null)
			return null;
		OperationDTO dto = new OperationDTO();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setSymbolFrom(entity.getSymbolFrom());
		dto.setSymbolTo(entity.getSymbolTo());
		dto.setAmountFrom(entity.getAmountFrom());
		dto.setAmountTo(entity.getAmountTo());
		dto.setCreatedAt(entity.getCreatedAt());
		return dto;
	}

	@Override
	public Operation dtoToEntity(OperationDTO dto) {
		if (dto == null)
			return null;
		Operation entity = new Operation();
		entity.setId(dto.getId());
		entity.setUsername(dto.getUsername());
		entity.setSymbolFrom(dto.getSymbolFrom());
		entity.setSymbolTo(dto.getSymbolTo());
		entity.setAmountFrom(dto.getAmountFrom());
		entity.setAmountTo(dto.getAmountTo());
		entity.setCreatedAt(dto.getCreatedAt());
		return entity;
	}

}
