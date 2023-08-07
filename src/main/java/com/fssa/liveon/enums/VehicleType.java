package com.fssa.liveon.enums;

public enum VehicleType {
	BIKE("Bike"), Car("Car");

	private final String vehicletype;

	public String getVehicletype() {
		return vehicletype;
	}

	private VehicleType(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	
	
//	public static void main(String[] args){
//	BikeService v1 = BikeService.BIKE_WASH_AND_POLISH;
//	System.out.println(v1);
//}
	
}
