package com.fssa.liveon.enums;

public enum BikeService {
	BIKE_WASH_AND_POLISH("Bike wash and polish"), BREAKE_CLEANING("Brake Cleaning"),
	ENGINE_OIL_CHANGE("Engine Oil Change"), CLUTCH_ADJUSTMENT("Clutch Adjustment"),
	OIL_FILTER_CHANGE("Oil Filter Change");

	private final String vehicleservice;

	private BikeService(String vehicleservice) {
		this.vehicleservice = vehicleservice;
	}

	public String getBikeService() {
		return vehicleservice;
	}
	
}
