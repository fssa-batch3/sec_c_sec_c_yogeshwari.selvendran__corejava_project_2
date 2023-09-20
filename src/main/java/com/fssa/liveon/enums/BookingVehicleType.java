package com.fssa.liveon.enums;

public enum BookingVehicleType {
	

	/**
	 * Define two enum constants: BIKE and Car
	 */

	BIKE("Bike"), CAR("Car");

	

	/**
	 * Declare a private final instance variable to store the vehicle type
	 */
	private final String vehicleType;

	/**
	 * Constructor for the enum, taking a vehicleType parameter
	 * 
	 * @param vehicleType
	 */
	private BookingVehicleType(String vehicleType) {
		/**
		 * Initialize the instance variable with the provided vehicleType
		 */
		this.vehicleType = vehicleType;
	}

	/**
	 * Public method to get the vehicle type of the enum constant
	 * 
	 * @return
	 */
	public String getVehicleType() {
		/**
		 * Return the stored vehicleType value
		 */
		return vehicleType;
	}

}
