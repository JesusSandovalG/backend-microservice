package com.service.vehicle.dao;

import org.springframework.data.repository.CrudRepository;

import com.service.vehicle.entity.Vehicle;

public interface VehicleDao extends CrudRepository<Vehicle, Long>{

}
