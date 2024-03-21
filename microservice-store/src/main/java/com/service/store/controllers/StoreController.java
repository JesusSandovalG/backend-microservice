package com.service.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.service.store.entity.Store;
import com.service.store.service.StoreService;

@RestController
public class StoreController {
	@Autowired
	@Qualifier("serviceFeign")
	private StoreService storeService;
	@GetMapping("/list")
	public List<Store> list(){
		return storeService.findAll();
	}
	
	@GetMapping("/vehicle/{id}/amount/{amount}")
	public Store details(@PathVariable Long id, @PathVariable Integer amount) {
		return storeService.findById(id, amount);
	}
	
}
