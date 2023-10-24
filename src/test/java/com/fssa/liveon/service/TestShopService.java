package com.fssa.liveon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.liveon.builder.ShopBuilder;
import com.fssa.liveon.exceptions.DAOException;
import com.fssa.liveon.model.Shop;
import com.fssa.liveon.util.Logger;

public class TestShopService {
	static Logger logger = new Logger();
	ShopService sp = new ShopService();

	public Shop getValidShop() {
		List<String> items = Arrays.asList("https://iili.io/Hv6Okvf.png", "https://iili.io/Hv6Okvf.png",
				"https://iili.io/Hv6Okvf.png");
		Shop shop = new ShopBuilder().buildPartnerId(1).buildShopName("MegaMart").buildShopLicenceNumber("ABC123")
				.buildShopServicedVehicleType("car").buildShopDetails("The shop details").buildImageUrl(items)
				.buildShopNumber(9876543210l).buildStreetAddress("north street").buildCity("madurai")
				.buildPostalCode("654321").buildPartnerId(1).build();
		return shop;
	}

	public Shop getValidShop1() {
		List<String> items = Arrays.asList("https://iili.io/Hv6Okvf.png", "https://iili.io/Hv6Okvf.png",
				"https://iili.io/Hv6Okvf.png");
		Shop shop = new ShopBuilder().buildShopId(1).buildShopName("Mechanic shop").buildShopServicedVehicleType("Bike")
				.buildShopDetails("The shop details").buildImageUrl(items).buildShopNumber(9876543210l)
				.buildStreetAddress("north street").buildCity("kulamangalam").buildPostalCode("654321").build();
		return shop;
	}

	@Test
	void testAddShop() throws DAOException, SQLException {
		Shop s = getValidShop();
		Assertions.assertTrue(sp.addShop(s));
	}

	@Test
	void testUpdateShop() throws DAOException, SQLException {
		Shop ss = getValidShop1();
		Assertions.assertTrue(sp.upddateShop(ss));
	}

	@Test
	void testDeleteShop() throws DAOException, SQLException {
		Shop s = getValidShop1();
		Assertions.assertTrue(sp.deleteShop(1));
	}

	@Test
	void testShopByPartnerId() throws DAOException, SQLException {

		List<Shop> resultShopList = sp.getShopByPartnerId(1);

	}

	@Test
	void testShopById() throws DAOException, SQLException {
		
	Shop spu=new Shop();
	spu=sp.getShopById(1);
	logger.info(spu);
	}

	@Test
	void testGetAllShop() throws DAOException, SQLException {
		// Creating a valid Product instance
		// SparePart p = getValidSparePart();
		// Creating a ProductService instance
		List<Shop> shopList = sp.getAllShopDetails();
		for (Shop ss : shopList) {
			logger.info(ss);
		}
		// Asserting that the getProductDetail method returns true
	}
}
