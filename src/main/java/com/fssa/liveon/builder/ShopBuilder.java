package com.fssa.liveon.builder;

import java.util.List;

import com.fssa.liveon.model.Shop;

public class ShopBuilder {
	 private int shopIdForBuilder;
	    private String shopNameForBuilder;
	    private List<String> imageUrlForBuilder;
	    private long shopNumberForBuilder;
	    private String shopLicenceNumberForBuilder;
	    private String streetAddressForBuilder;
	    private String cityForBuilder;
	    private String postalCodeForBuilder;
	    private String shopDetailsForBuilder;
	    private String shopServicedVehicleTypeForBuilder;
	    
	    
	    
	    
	    public ShopBuilder buildShopId(int shopId) {
	        this.shopIdForBuilder = shopId;
	        return this;
	    }


	    public ShopBuilder buildShopName(String shopName) {
	        this.shopNameForBuilder = shopName;
	        return this;
	    }

	    public ShopBuilder buildImageUrl(List<String> imageUrl) {
	        this.imageUrlForBuilder = imageUrl;
	        return this;
	    }

	    public ShopBuilder buildShopNumber(long shopNumber) {
	        this.shopNumberForBuilder = shopNumber;
	        return this;
	    }

	    public ShopBuilder buildShopLicenceNumber(String shopLicenceNumber) {
	        this.shopLicenceNumberForBuilder = shopLicenceNumber;
	        return this;
	    }

	    public ShopBuilder buildStreetAddress(String streetAddress) {
	        this.streetAddressForBuilder = streetAddress;
	        return this;
	    }

	    public ShopBuilder buildCity(String city) {
	        this.cityForBuilder = city;
	        return this;
	    }

	    public ShopBuilder buildPostalCode(String postalCode) {
	        this.postalCodeForBuilder = postalCode;
	        return this;
	    }
	    public ShopBuilder buildShopDetails(String shopDetails) {
	        this.shopDetailsForBuilder = shopDetails;
	        return this;
	    }

	    public ShopBuilder buildShopServicedVehicleType(String vehicleType) {
	        this.shopServicedVehicleTypeForBuilder = vehicleType;
	        return this;
	    }
	    
	    public Shop build() {
	    	Shop shop = new Shop();
	        shop.setShopId(shopIdForBuilder);
	        shop.setShopName(shopNameForBuilder);
	        shop.setImageUrl(imageUrlForBuilder);
	        shop.setShopNumber(shopNumberForBuilder);
	        shop.setShopLicenceNumber(shopLicenceNumberForBuilder);
	        shop.setStreetAddress(streetAddressForBuilder);
	        shop.setCity(cityForBuilder);
	        shop.setPostalCode(postalCodeForBuilder);
	        shop.setShopDetails(shopDetailsForBuilder);
	        shop.setVehicleType(shopServicedVehicleTypeForBuilder);
	    	return shop;
	    }
}
