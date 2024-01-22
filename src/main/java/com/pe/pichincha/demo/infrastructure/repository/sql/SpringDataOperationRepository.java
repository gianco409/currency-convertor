package com.pe.pichincha.demo.infrastructure.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.pichincha.demo.infrastructure.repository.entity.Operation;

public interface SpringDataOperationRepository extends JpaRepository<Operation, Long> {

}
