package com.fssa.liveon.validator;

import com.fssa.liveon.enums.BikeService;
import com.fssa.liveon.enums.BookingVehicleType;
import com.fssa.liveon.enums.CarService;
import com.fssa.liveon.enums.Category;
import com.fssa.liveon.exceptions.InvalidBookingDetailException;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;

public  class EnamValidation {
	public EnamValidation() {
		// private constructor
	}

	/**
	 * validation method for validating vehicle types
	 * 
	 * @param vehicleType
	 * @return
	 * @throws InvalidSparePartDetailsException
	 */
	public  boolean validVehicleType(String vehicleType) throws InvalidSparePartDetailsException {
		if (vehicleType == null) {

			throw new InvalidSparePartDetailsException(SparePartValidationsErrors.EMPTY_VEHICLETYPE);
		}

		for (Category category : Category.values()) {
			if (category.getVehicleType().equalsIgnoreCase(vehicleType)) {
				return true;

			}
		}
		throw new InvalidSparePartDetailsException(SparePartValidationsErrors.INVALID_VEHICLETYPE);
	}
	

	
}
