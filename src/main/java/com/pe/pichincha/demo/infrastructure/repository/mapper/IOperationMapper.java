package com.pe.pichincha.demo.infrastructure.repository.mapper;

import com.pe.pichincha.demo.domain.dto.OperationDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.Operation;

public interface IOperationMapper {
	OperationDTO entityToDto(Operation entity);
	Operation dtoToEntity(OperationDTO dto);
}
