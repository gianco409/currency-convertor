package com.pe.pichincha.demo.infrastructure.repository.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.pichincha.demo.domain.dto.UserDTO;
import com.pe.pichincha.demo.domain.repository.UserRepository;
import com.pe.pichincha.demo.infrastructure.repository.mapper.IUserMapper;

@Component
public class SqlUserRepository implements UserRepository {

	@Autowired
	private SpringDataUserRepository springDataUserRepository;

	@Autowired
	private IUserMapper userMapper;

	@Override
	public void save(UserDTO user) {
		springDataUserRepository.save(userMapper.dtoToEntity(user));
	}

}
