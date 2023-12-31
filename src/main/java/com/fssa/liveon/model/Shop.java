package com.fssa.liveon.model;

import java.util.List;

public class Shop {
	private int shopId;
	private int partnerId;
	private String shopName;
	private List<String> imageUrl;
	private long shopNumber;
	private String shopLicenceNumber;
	private String streetAddress;
	private String city;
	private String postalCode;
	private String vehicleType;
	private String shopDetails;
	private Partners partners;
	private boolean shopStatus;
	

	public Partners getPartners() {
		return partners;
	}
	public void setPartners(Partners partners) {
		this.partners = partners;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<String> getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(long shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getShopLicenceNumber() {
		return shopLicenceNumber;
	}
	public void setShopLicenceNumber(String shopLicenceNumber) {
		this.shopLicenceNumber = shopLicenceNumber;
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getShopDetails() {
		return shopDetails;
	}
	public void setShopDetails(String shopDetails) {
		this.shopDetails = shopDetails;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public boolean isSparepartstatus() {
		return shopStatus;
	}
	public void setSparepartstatus(boolean sparepartstatus) {
		this.shopStatus = sparepartstatus;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", partnerId=" + partnerId + ", shopName=" + shopName + ", imageUrl="
				+ imageUrl + ", shopNumber=" + shopNumber + ", shopLicenceNumber=" + shopLicenceNumber
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", postalCode=" + postalCode
				+ ", vehicleType=" + vehicleType + ", shopDetails=" + shopDetails + ", partners=" + partners
				+ ", shopstatus=" + shopStatus + "]";
	}
	
}
