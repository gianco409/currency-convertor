package com.pe.pichincha.demo.infrastructure.repository.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.OperationDTO;
import com.pe.pichincha.demo.domain.repository.OperationRepository;
import com.pe.pichincha.demo.infrastructure.repository.mapper.IOperationMapper;

@Component
public class SqlOperationRepository implements OperationRepository {

	@Autowired
	private SpringDataOperationRepository springDataOperationRepository;
	@Autowired
	private IOperationMapper operationMapper;

	@Override
	public void save(OperationDTO operation) {
		springDataOperationRepository.save(operationMapper.dtoToEntity(operation));
	}

}
