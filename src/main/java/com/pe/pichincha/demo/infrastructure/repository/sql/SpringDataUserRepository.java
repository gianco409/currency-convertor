package com.pe.pichincha.demo.infrastructure.repository.sql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.pichincha.demo.infrastructure.repository.entity.User;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
