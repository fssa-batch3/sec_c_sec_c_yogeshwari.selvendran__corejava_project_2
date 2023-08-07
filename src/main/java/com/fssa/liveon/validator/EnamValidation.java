package com.fssa.liveon.validator;
import com.fssa.liveon.enums.VehicleType;
import com.fssa.liveon.exceptions.InvalidProductDetailsException;


public class EnamValidation {
	// create a validation for vehicle type
	
		public static boolean ValidVehicleType(String vehicleType)throws InvalidProductDetailsException {
			if(vehicleType==null) {
				
				  throw new InvalidProductDetailsException(ProductValidationsErrors.EMPTY_VEHICLETYPE); 
			}
			
	        for (VehicleType type : VehicleType.values()) {
	            if (!(type.getVehicletype().equalsIgnoreCase(vehicleType))) {
	            	
	            	  throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_VEHICLETYPE); 
	            }
	        }
	        return true;
}
}
