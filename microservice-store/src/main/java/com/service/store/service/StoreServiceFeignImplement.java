package com.service.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.service.store.client.VehicleClientFeign;
import com.service.store.entity.Store;

@Service("serviceFeign")
@Primary 
public class StoreServiceFeignImplement implements StoreService {

	@Autowired
	private VehicleClientFeign clientFeign;
	
	@Override
	public List<Store> findAll() {
		return clientFeign.list().stream().map(c -> new Store(c,5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer amount) {
		return new Store(clientFeign.detail(id), amount);
	}

}
