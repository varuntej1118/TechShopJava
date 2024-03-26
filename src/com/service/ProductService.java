package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProdDaoImp;
import com.exception.InventoryNotFoundException;
import com.model.Inventory;
import com.model.Products;

public class ProductService {
	ProdDaoImp productDaoImpl=new ProdDaoImp();
	public List<Products> getProductDetails() throws SQLException {
		return productDaoImpl.getProductDetails();
	}
	public void updateProductName(int pid, String productName) throws SQLException {
		productDaoImpl.updateProductName(pid, productName);
	}
	public void updateDescription(int pid, String description) throws SQLException {
		productDaoImpl.updateDescription(pid,description);
	}
	public void updatePrice(int pid, double price) throws SQLException {
		productDaoImpl.updatePrice(pid,price);
	}
	public boolean checkAvailability(Inventory i, int pid1) {
		if(i.getProductId()==pid1) {
			if(i.getQuantityInStock()>0) {
				return true;
			}
		}
		return false;
	}
	public Inventory getInventoryDetails(int pid1) throws SQLException, InventoryNotFoundException {
		return productDaoImpl.getInventoryDetails(pid1);
	}

}
