package com.fssa.liveon.validator;

public class ProductValidationsErrors {
	
	
	private ProductValidationsErrors() {
		//private constructor
	}
	
	public static final String INVALID_PRODUCTOBJECT = "product inputs can not be null or empty";
//	Invalid product name
	public static final String INVALID_PRODUCT_NAME_NULL = "Product name  cannot be empty or null";
	public static final String INVALID_PRODUCT_NAME = "The name should be  minimum 2 letters and maximum 35 letters";
//	Invalid product price
	public static final String INVALID_PRODUCTPRICE = "Product price should be  greater than or equal to 500  and lesser then or equal to 30000";
//	product rating
	public static final String INVALID_PRODUCTRATING = "Product rating is greater than or equal to 1 and lesser than or equal 5";
//  vehicle type	
	public static final String INVALID_VEHICLETYPE = "Vehicle type is invalid";
	public static final String EMPTY_VEHICLETYPE = "Vehicle type cannot be null or empty";
//	About product 
	public static final String INVALID_ABOUTPRODUCT_NULL = "Product details is cannot be empty or null";
	public static final String INVALID_ABOUTPRODUCT = "The name should be  minimum 2 letters and maximum 100 letters";
//	Product Description
	public static final String INVALID_PRODUCT_DESCRIPTION_NULL = "Product description is cannot be empty or null";
	public static final String INVALID_PRODUCT_DESCRIPTION = "The name should be  minimum 2 letters and maximum 300 letters";
//	Product image url 
	public static final String INVALID_PRODUCTIMAGE_NULL = "Images is cannot be in null or empty ";
	public static final String INVALID_PRODUCTIMAGE = "Images url is invalid";
//	Add Product
	public static final String INVALID_ADD_PRODUCT = "The method getProductPrice() returns null";
//	Product id validate
	public static final String INVALID_PRODUCTID = "The product id is invalid";
}
