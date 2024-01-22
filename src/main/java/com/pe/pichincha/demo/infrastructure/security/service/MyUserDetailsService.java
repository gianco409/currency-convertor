package com.pe.pichincha.demo.infrastructure.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pe.pichincha.demo.infrastructure.repository.entity.User;
import com.pe.pichincha.demo.infrastructure.repository.sql.SpringDataUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private SpringDataUserRepository springDataUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = springDataUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

}
