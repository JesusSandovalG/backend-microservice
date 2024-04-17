package com.service.vehicle.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.vehicle.entity.Vehicle;
import com.service.vehicle.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	private VehicleService microService;
	
	
	@Value("${server.port}")
	private Integer port;
	
	//Def endpoints
	@GetMapping("/list")
	public List<Vehicle> list(){
		return microService.findAll().stream().map(vel -> {
			vel.setPort(port);
			return vel;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/vehicle/{id}")
	public Vehicle detail(@PathVariable Long id) {
		return microService.findById(id);
	}
	
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Void> drop(@PathVariable Long id) {
		microService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/vehicle")
	public ResponseEntity<Vehicle> add(@RequestBody Vehicle instance){
		Vehicle vel = microService.save(instance);
		return new ResponseEntity<>(vel, HttpStatus.CREATED);
	}
	
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle instance){
		if(microService.existsById(id)) {
			instance.setId(id);
			Vehicle vel = microService.save(instance);
			return new ResponseEntity<>(vel, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
