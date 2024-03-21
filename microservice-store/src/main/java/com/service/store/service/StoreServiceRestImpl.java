package com.service.store.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.store.entity.Store;
import com.service.store.entity.Vehicle;

@Service
public class StoreServiceRestImpl implements StoreService {
	@Autowired
	private RestTemplate clientRest;
	@Override
	public List<Store> findAll() {
		List<Vehicle> vehicles = Arrays.asList(clientRest.getForObject("http://localhost:8081/list", Vehicle[].class));
		return vehicles.stream().map(c -> new Store(c,5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer amount) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Vehicle veh = clientRest.getForObject("http://localhost:8081/vehicle/{id}", Vehicle.class, pathVariables);
		return new Store(veh, amount);
	}

}
