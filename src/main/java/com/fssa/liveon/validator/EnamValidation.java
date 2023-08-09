package com.fssa.liveon.validator;
import com.fssa.liveon.enums.Category;
import com.fssa.liveon.exceptions.InvalidProductDetailsException;


public class EnamValidation {

	/**
	 *  validation method for validating vehicle types
	 * @param vehicleType
	 * @return
	 * @throws InvalidProductDetailsException
	 */
		public static boolean validVehicleType(String vehicleType)throws InvalidProductDetailsException {
			if(vehicleType==null) {
				
				  throw new InvalidProductDetailsException(ProductValidationsErrors.EMPTY_VEHICLETYPE); 
			}
			
	        for (Category category : Category.values()) {
	            if(category.getVehicleType().equalsIgnoreCase(vehicleType)) {
	            	   return true;
	            	  
	            }
	        }
	        throw new InvalidProductDetailsException(ProductValidationsErrors.INVALID_VEHICLETYPE); 
}
	
}
