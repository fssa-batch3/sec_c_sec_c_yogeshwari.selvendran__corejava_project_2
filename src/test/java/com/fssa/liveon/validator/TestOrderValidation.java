package com.fssa.liveon.validator;

import java.security.Timestamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.exceptions.InvalidOrderDetailsException;
import com.fssa.liveon.model.Orders;

public class TestOrderValidation {
	OrdersValidation orderValidate = new OrdersValidation();
	@Test
	void testValidOrder() {
		Orders order = new Orders(2,3,"123 Main St","City","12345","Credit Card");
		Assertions.assertTrue(orderValidate.validateOrderDetails(order));
	}
	@Test
	public void testValidStreet() {
	String Street = "123 Main St";
		Assertions.assertTrue(OrdersValidation.validStreetAddress(Street));
	}
	
	@Test
	public void testInvalidStreet() {
		try {
			OrdersValidation.validStreetAddress(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.EMPTY_STREED_ADDRESS, e.getMessage());
		}

		try {
			OrdersValidation.validStreetAddress("8754321");
			
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.EMPTY_STREED_ADDRESS, e.getMessage());
		}
	}
	
	@Test
	public void testValidCity() {
	String City = "Madurai";
		Assertions.assertTrue(OrdersValidation.validCity(City));
	}
	
	@Test
	public void testInvalidCity() {
		try {
			OrdersValidation.validCity(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.EMPTY_CITY_ADDRESS, e.getMessage());
		}

		try {
			OrdersValidation.validCity("8754321");
			
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.INVALID_CITY_ADDRESS, e.getMessage());
		}
	}

	@Test
	public void testValidPostalCode() {
	String Pincode = "654321";
		Assertions.assertTrue(OrdersValidation.validCity(Pincode));
	}
	
	@Test
	public void testInvalidPostalCode() {
		try {
			OrdersValidation.validCity(null);
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.EMPTY_POSTALCODE, e.getMessage());
		}

		try {
			OrdersValidation.validCity("north");
			
			Assertions.fail("Tset case failed");
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.INVALID_POSTALCODE, e.getMessage());
		}
	}

	@Test
	void testValidOrderId() {
		Assertions.assertTrue(OrdersValidation.validOrderId(0));
	}

	@Test
	void testInvalidOrderId() {
		try {
			OrdersValidation.validOrderId(-3);
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.INVALID_ORDERID, e.getMessage());
		}
}
	@Test
	void testValidUserId() {
		Assertions.assertTrue(OrdersValidation.validUserId(0));
	}

	@Test
	void testInvalidUserId() {
		try {
			OrdersValidation.validUserId(-2);
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.INVALID_USERID, e.getMessage());
		}
}
	void testValidSparepartId() {
		Assertions.assertTrue(OrdersValidation.validSparePartId(0));
	}

	@Test
	void testInvalidSparepartId() {
		try {
			OrdersValidation.validSparePartId(-1);
		} catch (InvalidOrderDetailsException e) {
			Assertions.assertEquals(OrderValidationErrors.INVALID_SPAREPART_ID, e.getMessage());
		}
}
	@Test

	void testPaymentMethod() {
		String PaymentMethod = "Cash on delevery";
		try {
			OrdersValidation.validPaymentMethod(PaymentMethod);
		} catch (InvalidOrderDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

		String PaymentMethod1 = "UPI Payments";

		try {
			OrdersValidation.validPaymentMethod(PaymentMethod1);
		} catch (InvalidOrderDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(SparePartValidationsErrors.INVALID_VEHICLETYPE, e.getMessage());
		}

	}

// Test invalid vehicle type
	@Test
	void testInvalidPaymentMethod() {
//	empty vehicle type
		try {
			// Validating a null Product object should throw an
			// InvalidProductDetailsException
			OrdersValidation.validPaymentMethod(null);
			Assertions.fail("Test case failed");
		} catch (InvalidOrderDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(OrderValidationErrors.EMPTY_PAYMENT_METHOD, e.getMessage());
		}
//	invalid vehicle type
		try {
			OrdersValidation.validPaymentMethod("EMI");
			Assertions.fail("Test case failed");
		} catch (InvalidOrderDetailsException e) {
			// Asserting that the exception message matches the expected error message
			Assertions.assertEquals(OrderValidationErrors.INVALID_PAYMENT_METHOD, e.getMessage());
		}
	}
}
