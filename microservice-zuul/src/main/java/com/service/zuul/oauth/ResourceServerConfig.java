package com.service.zuul.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(jwtTokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/security/oauth/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/vehicle/list", "/api/store/list", "/api/us/users").permitAll()
		.antMatchers(HttpMethod.GET, "/api/vehicle/vehicle/id",
				"/api/store//vehicle/{id}/amount/{amount}",
				"/api/us/users/{id}").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/api/vehicle/vehicle", "/api/us/users").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/vehicle/vehicle/{id}", "/api/us/users/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/vehicle/vehicle/{id}", "/api/us/users/{id}").hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public JwtTokenStore jwtTokenStore() {
		return  new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("key_4x4");
		return tokenConverter;
	}
}
