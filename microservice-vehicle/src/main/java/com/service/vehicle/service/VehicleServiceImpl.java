package com.service.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.vehicle.dao.VehicleDao;
import com.service.vehicle.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleDao dao;
	
	@Override
	public List<Vehicle> findAll() {
		return (List<Vehicle>) dao.findAll();
	}

	@Override
	public Vehicle findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Vehicle save(Vehicle instance) {
		return dao.save(instance);
	}

	@Override
	public boolean existsById(Long id) {
		return dao.existsById(id);
	}

}
