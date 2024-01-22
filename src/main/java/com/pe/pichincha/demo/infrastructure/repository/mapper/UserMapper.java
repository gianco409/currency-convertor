package com.pe.pichincha.demo.infrastructure.repository.mapper;

import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.UserDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.User;

@Component
public class UserMapper implements IUserMapper {

	@Override
	public UserDTO entityToDto(User entity) {
		if (entity == null)
			return null;
		UserDTO dto = new UserDTO();
		dto.setUserId(entity.getUserId());
		dto.setUsername(entity.getUsername());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setActive(entity.getActive());
		return dto;
	}

	@Override
	public User dtoToEntity(UserDTO dto) {
		if (dto == null)
			return null;
		User entity = new User();
		entity.setUserId(dto.getUserId());
		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setActive(dto.getActive());
		return entity;
	}

}
