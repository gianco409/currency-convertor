package com.pe.pichincha.demo.domain.repository;

import com.pe.pichincha.demo.domain.dto.UserDTO;

public interface UserRepository {
	void save(UserDTO user);

}
