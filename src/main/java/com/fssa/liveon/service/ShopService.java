package com.fssa.liveon.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.liveon.dao.ShopDAO;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Shop;
import com.fssa.liveon.model.SparePart;
import com.fssa.liveon.validator.ShopValidation;

public class ShopService {
	ShopDAO shopDao = new ShopDAO();
	ShopValidation shopValidation = new ShopValidation();

	public boolean addShop(Shop shop) throws DAOException, SQLException {
		if (shopValidation.validateShop(shop)) {
			shopDao.addShop(shop);
		}
		return true;
	}

	public boolean upddateShop(Shop shop) throws DAOException, SQLException {
		if (shopValidation.updateShop(shop)) {
			shopDao.updateShop(shop);
		}
		return true;
	}

	public boolean deleteShop(int shopId) throws DAOException, SQLException {
		if (shopValidation.shopIdValidate(shopId)) {
		}
		return true;
	}

	public List<Shop> getShopByPartnerId(int id) throws DAOException, SQLException {
		return shopDao.getShopDetailByPartnerId(id);
	}
	public Shop getShopById(int Id) throws DAOException, SQLException {
		return shopDao.getShopDetailById(Id);
	}
	public List<Shop> getAllShopDetails() throws DAOException, SQLException {

		return shopDao.getAllShops();
	}
}
