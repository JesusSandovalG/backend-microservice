package com.service.store.service;

import java.util.List;

import com.service.store.entity.Store;

public interface StoreService {

	public List<Store> findAll();
	
	public Store findById(Long id, Integer amount);
	
}
