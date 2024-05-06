package com.service.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.service.commons.users.entity.User;
import com.service.oauth.service.UserService;

@Component
public class InfoToken implements TokenEnhancer{

	@Autowired
	private UserService service;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		
		User user = service.findByUsername(authentication.getName());
		info.put("name", user.getName());
		info.put("email", user.getEmail());
		info.put("Claim", "Value");
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
		
	}

}
