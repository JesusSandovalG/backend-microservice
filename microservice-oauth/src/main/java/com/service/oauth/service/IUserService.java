package com.service.oauth.service;

import com.service.commons.users.entity.User;

public interface IUserService {

	public User findByUsername(String username);
}
