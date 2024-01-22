package com.pe.pichincha.demo.infrastructure.repository.mapper;

import com.pe.pichincha.demo.domain.dto.UserDTO;
import com.pe.pichincha.demo.infrastructure.repository.entity.User;

public interface IUserMapper {
	UserDTO entityToDto(User entity);
	User dtoToEntity(UserDTO dto);
}
