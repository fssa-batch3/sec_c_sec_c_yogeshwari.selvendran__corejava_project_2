package com.fssa.liveon.model;

import java.util.List;

public class Product {
	/**
	 * Declare instance variables for the Product class
	 */
	private String vehicleType;
	private String productName;
	private double price;
	private int rating;
	private List<String> imageUrl;
	private String aboutProduct;
	private String description;
	private int productId;

	/**
	 * Constructor with parameters for initializing all instance variables
	 * 
	 * @param vehicleType
	 * @param productName
	 * @param price
	 * @param rating
	 * @param imageUrl
	 * @param aboutProduct
	 * @param description
	 */
	public Product(String vehicleType, String productName, double price, int rating, List<String> imageUrl,
			String aboutProduct, String description) {
		super();
		/**
		 * Calling the constructor of the parent class (Object) Initialize instance
		 * variables with values from the parameters
		 */
		this.vehicleType = vehicleType;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.aboutProduct = aboutProduct;
		this.description = description;
	}

	/**
	 * Constructor with parameters including productId for initializing all instance
	 * variables
	 * 
	 * @param productId
	 * @param vehicleType
	 * @param productName
	 * @param price
	 * @param rating
	 * @param imageUrl
	 * @param aboutProduct
	 * @param description
	 */
	public Product(int productId, String vehicleType, String productName, double price, int rating,
			List<String> imageUrl, String aboutProduct, String description) {
		super();
		/**
		 * Calling the constructor of the parent class (Object) Initialize instance
		 * variables with values from the parameters
		 */
		this.productId = productId;
		this.vehicleType = vehicleType;
		this.productName = productName;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.aboutProduct = aboutProduct;
		this.description = description;
	}

	/**
	 * Default constructor with no parameters
	 */
	public Product() {
		/**
		 * This constructor does not initialize any instance variables
		 */
	}

	/**
	 * Getter and setter methods for the instance variables
	 * 
	 * @return
	 */
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
