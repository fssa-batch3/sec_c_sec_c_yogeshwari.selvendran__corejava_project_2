package com.fssa.liveon.model;

import java.security.Timestamp;

public class Orders {

	 private int orderID;
	    private int sparepartId;
	    private int userId;
	    private Timestamp dateAdded;
	    private String orderStatus;
	    private String streetAddress;
	    private String city;
	    private String postalCode;
	    private String paymentmethod;
	    
		public Orders( int sparepartId, int userId,
		String streetAddress, String city, String postalCode, String paymentmethod) {
			super();
		//	this.orderID = orderID;
			this.sparepartId = sparepartId;
			this.userId = userId;
			// this.dateAdded = dateAdded;
		//	this.orderStatus = orderStatus;
			this.streetAddress = streetAddress;
			this.city = city;
			this.postalCode = postalCode;
			this.paymentmethod = paymentmethod;
		}

		public Orders() {
			// TODO Auto-generated constructor stub
		}

		public int getOrderID() {
			return orderID;
		}

		public void setOrderID(int orderID) {
			this.orderID = orderID;
		}

		public int getSparepartId() {
			return sparepartId;
		}

		public void setSparepartId(int sparepartId) {
			this.sparepartId = sparepartId;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public Timestamp getDateAdded() {
			return dateAdded;
		}

		public void setDateAdded(Timestamp dateAdded) {
			this.dateAdded = dateAdded;
		}

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		public String getStreetAddress() {
			return streetAddress;
		}

		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getPaymentmethod() {
			return paymentmethod;
		}

		public void setPaymentmethod(String paymentmethod) {
			this.paymentmethod = paymentmethod;
		}

		public void setDateAdded(java.sql.Timestamp timestamp) {
			// TODO Auto-generated method stub
			
		}

	
}
