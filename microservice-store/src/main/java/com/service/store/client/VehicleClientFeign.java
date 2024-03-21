package com.service.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.store.entity.Vehicle;
@FeignClient(name = "service-vehicle", url = "localhost:8081")
public interface VehicleClientFeign {
	
	@GetMapping("/list")
	public List<Vehicle> list();
	
	@GetMapping("vehicle/{id}")
	public Vehicle detail(@PathVariable Long id);
}
