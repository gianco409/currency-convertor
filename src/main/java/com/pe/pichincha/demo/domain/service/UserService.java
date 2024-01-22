package com.pe.pichincha.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pe.pichincha.demo.application.request.AuthSignUp;
import com.pe.pichincha.demo.domain.dto.UserDTO;
import com.pe.pichincha.demo.domain.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(AuthSignUp authSignUp) {
		UserDTO user = new UserDTO();
		user.setUsername(authSignUp.getUsername());
		user.setPassword(passwordEncoder.encode(authSignUp.getPassword()));
		user.setActive(true);
		userRepository.save(user);
	}

}
