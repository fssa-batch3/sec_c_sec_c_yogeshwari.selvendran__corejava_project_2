package com.fssa.liveon.enums;

public enum CarService {
	
	AIR_CONDITIONING_REPAIR_SERVICE("Air conditioning repair services"),
	ENGINE_OIL_REPLACEMENT("Engine oil replacement"), WHEEL_ALIGNMENT("Wheel alignment"),
	CAR_WASH_AND_POLISH("Car wash and polish"), DENT_AND_SCRATCH_REPAIR("Dent and scratch repair");

	private final String carService;
	public String getCarService() {	
		return carService;	
	}

	private CarService(String carService) {
		this.carService = carService;
	}
	
//	public static void main(String[] args) {
//		System.out.println(carService.values());
//	}
}
