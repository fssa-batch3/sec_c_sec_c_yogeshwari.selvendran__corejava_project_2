package com.fssa.liveon.validator;

import com.fssa.liveon.enums.Category;
import com.fssa.liveon.exceptions.InvalidSparePartDetailsException;

public  class EnamValidation {
	private EnamValidation() {
		// private constructor
	}

	/**
	 * validation method for validating vehicle types
	 * 
	 * @param vehicleType
	 * @return
	 * @throws InvalidSparePartDetailsException
	 */
	public static boolean validVehicleType(String vehicleType) throws InvalidSparePartDetailsException {
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
