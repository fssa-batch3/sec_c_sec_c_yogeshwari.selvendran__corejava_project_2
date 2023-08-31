package com.fssa.liveon.model;

import java.util.List;

public class SparePart {
	@Override
	public String toString() {
		return "SparePart [vehicleType=" + vehicleType + ", name=" + name + ", price=" + price + ", rating=" + rating
				+ ", imageUrl=" + imageUrl + ", description=" + description + ", id=" + id + ", getVehicleType()="
				+ getVehicleType() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getRating()="
				+ getRating() + ", getImageUrl()=" + getImageUrl() + ", getDescription()=" + getDescription()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * Declare instance variables for the Product class
	 */
	private String vehicleType;
	private String name;
	private double price;
	private int rating;
	private List<String> imageUrl;
	private String description;
	private int id;

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
	public SparePart(String vehicleType, String name, double price, int rating, List<String> imageUrl, String description) {
		super();
		/**
		 * Calling the constructor of the parent class (Object) Initialize instance
		 * variables with values from the parameters
		 */
		this.vehicleType = vehicleType;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
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
	public SparePart(int id, String vehicleType, String name, double price, int rating,
			List<String> imageUrl, String description) {
		super();
		/**
		 * Calling the constructor of the parent class (Object) Initialize instance
		 * variables with values from the parameters
		 */
		this.id = id;
		this.vehicleType = vehicleType;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	/**
	 * Default constructor with no parameters
	 */
	public SparePart() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int productId) {
		this.id = productId;
	}

}
