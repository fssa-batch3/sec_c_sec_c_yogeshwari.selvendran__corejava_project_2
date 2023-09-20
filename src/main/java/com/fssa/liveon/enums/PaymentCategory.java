package com.fssa.liveon.enums;

public enum PaymentCategory {
	CASE_ON_DELEVERY("Cash on Delivery"), UPI_PAYMENTS("Upi payments"), CREATE_CARD("Credit Card");

	private final String paymentmethod;

	private PaymentCategory(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

}
