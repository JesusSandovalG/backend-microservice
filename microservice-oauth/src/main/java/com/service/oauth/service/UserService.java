package com.service.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.service.commons.users.entity.User;
import com.service.oauth.client.UserFeignClient;

@Service
public class UserService implements UserDetailsService, IUserService{

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = client.findByUsername(username);
		
		if(user==null) {
			log.error("Error login, not exists. "+username);
			throw new UsernameNotFoundException("Error login, not exists. "+username);
		}
		
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> log.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		log.info("User authentication"+username);
		
		return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	@Override
	public User findByUsername(String username) {
		return client.findByUsername(username);
	}

}
