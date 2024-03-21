package com.service.vehicle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.vehicle.entity.Vehicle;

@Service
public interface VehicleService {
	public List<Vehicle> findAll();
	
	public Vehicle findById(Long id);
	
	public void deleteById(Long id);
	
	public Vehicle save(Vehicle instance);
	
	public boolean existsById(Long id);
}
