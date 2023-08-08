package com.fssa.liveon.service;

import java.sql.SQLException;
import com.fssa.liveon.dao.ProductDao;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Product;
import com.fssa.liveon.validator.ProductValidation;

public class ProductService {
	private ProductValidation ProductValidation;
	private ProductDao ProductDao;
	public ProductService(ProductValidation productValidation,ProductDao productDao) {
		super();
		ProductValidation = productValidation;
		ProductDao = productDao;
	}
	public ProductService() {
		
	}
	public boolean addProduct(Product product)throws DAOException,SQLException{
		if(this.ProductValidation.validateProduct(product)) {
			this.ProductDao.addProduct(product);
		}
		return true;
	}
	public boolean updateProduct(Product product)throws DAOException,SQLException{
		if(this.ProductValidation.validateProduct(product)) {
			this.ProductDao.updateProduct(product);
		}
		return true;
	}
	public boolean deleteProduct(int productId)throws DAOException,SQLException{
		ProductValidation productValidation = new ProductValidation();
		if(productValidation.productIdValidate(productId)) {
			this.ProductDao.deleteProduct(productId);
		}
		return true;
	}
	public boolean getProductDetail()throws DAOException,SQLException {
		ProductDao  productdao = new ProductDao();
		productdao.getAllProduct();
		return true;
	}
}
