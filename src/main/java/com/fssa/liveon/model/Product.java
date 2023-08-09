package com.fssa.liveon.model;

import java.util.List;

public class Product {
	private String vehicleType;
	private String productName;
    private double price;
    private int rating;
    private List<String> imageUrl; 
	private String aboutProduct;
    private String description;
    private int productId;
    
	

	public Product(String vehicleType, String productName, double price, int rating, List<String> imageUrl,
			String aboutProduct, String description) {
		super();
		this.vehicleType = vehicleType;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.aboutProduct = aboutProduct;
		this.description = description;
	}
	
	
	public Product(int productId, String vehicleType, String productName, double price, int rating, List<String> imageUrl,
			String aboutProduct, String description) {
		super();
		this.productId=productId;
		this.vehicleType = vehicleType;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.aboutProduct = aboutProduct;
		this.description = description;
	}

	public Product() {

	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAboutProduct() {
		return aboutProduct;
	}

	public void setAboutProduct(String aboutProduct) {
		this.aboutProduct = aboutProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	

}
