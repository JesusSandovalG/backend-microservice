package com.service.store.entity;

public class Store {
	
	private Vehicle veh;
	
	private Integer amount;

	public Store() {
		
	}
	
	public Store(Vehicle veh, Integer amount) {
		super();
		this.veh = veh;
		this.amount = amount;
	}

	public Vehicle getVeh() {
		return veh;
	}

	public void setVeh(Vehicle veh) {
		this.veh = veh;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
