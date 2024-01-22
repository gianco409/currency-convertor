package com.pe.pichincha.demo.domain.repository;

import com.pe.pichincha.demo.domain.dto.OperationDTO;

public interface OperationRepository {
	void save(OperationDTO operation);
}
