package com.service.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.service.user.entity.User;

@RepositoryRestResource(path="users")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	// select u from User u where u.username = ?1
	@RestResource(path="search-username")
	public User findByUsername(@Param("name") String username);
	
	// select u from User u where u.username = ?1 and u.email = ?2
	public User findByUsernameAndEmail(String username, String email);
	
	@Query(value = "select u from User u where u.username = ?1")
	public User getForUsername(String username);
	
	@Query(value = "select u from User u where u.username = ?1 and u.email = ?2")
	public User getForUsernameAndEmail(String username, String email);
	
}
