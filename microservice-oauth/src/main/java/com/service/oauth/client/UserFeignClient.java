package com.service.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.commons.users.entity.User;


@FeignClient("service-user")
public interface UserFeignClient {

	@GetMapping("/users/search/search-username")
	public User findByUsername(@RequestParam String username);
}
