package com.fssa.liveon.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.exceptions.InvalidProductDetailsException;
import com.fssa.liveon.model.Product;

public class TestProductDao {

	public static Product productValidate() {
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		Product product = new Product();
		product.setProductId(2);
		product.setVehicleType("Car");
		product.setProductName("Air filter");
		product.setPrice(2500);
		product.setRating(4);
		product.setAboutProduct("Sample about product");
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	public static Product productValidate2() {
		List<String> images = new ArrayList<>();
		images.add("https://iili.io/Hv6Okvf.png");
		images.add("https://iili.io/Hv6Okvf.png");
		Product product = new Product();

		product.setVehicleType("Car");
		product.setProductName("Air filter");
		product.setPrice(2500);
		product.setRating(4);
		product.setAboutProduct("Sample about product");
		product.setDescription("Sample product dsecription");
		product.setImageUrl(images);
		return product;
	}

	public static Product inValidProduct() {
		Product product = new Product();
		product.setProductId(-1);
		return product;
	}

	@Test
	public void testValidAddProduct() throws DAOException, SQLException {
		Assertions.assertTrue(ProductDao.addProduct(productValidate2()));
	}

	@Test
	public void testValidUpdateProduct() throws DAOException, SQLException {
		Assertions.assertTrue(ProductDao.addProduct(productValidate()));
	}

	@Test
	public void testValidDeleteProduct() throws DAOException, SQLException {
		Assertions.assertTrue(ProductDao.deleteProduct(3));
	}

	@Test
	public void testInvalidAddProduct() throws DAOException, SQLException {
		try {
			ProductDao.addProduct(productValidate());
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(productDaoErrors.INVALID_ADD_PRODUCT, e.getMessage());
		}
	}

	@Test
	public void testInvalidUpdateProduct() throws DAOException, SQLException {
		try {
			ProductDao.updateProduct(inValidProduct());
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(productDaoErrors.INVALID_PRODUCT_ID, e.getMessage());
		}
	}

	@Test
	public void testInvalidDeleteProduct() throws DAOException, SQLException {
		try {
			ProductDao.deleteProduct(inValidProduct().getProductId());
		} catch (InvalidProductDetailsException e) {
			Assertions.assertEquals(productDaoErrors.INVALID_PRODUCT_ID, e.getMessage());
		}
	}
}
