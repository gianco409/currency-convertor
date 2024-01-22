package com.pe.pichincha.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.pichincha.demo.domain.dto.OperationDTO;
import com.pe.pichincha.demo.domain.repository.OperationRepository;

@Service
public class OperationService implements IOperationService {

	@Autowired
	private OperationRepository operationRepository;

	@Override
	public void saveOperation(OperationDTO operation) {
		operationRepository.save(operation);
	}

}
