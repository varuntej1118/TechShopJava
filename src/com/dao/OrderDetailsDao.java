package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDetailsOfCustomersDto;
import com.exception.ProductNotFoundException;
import com.model.Products;

public interface OrderDetailsDao {

	List<OrderDetailsOfCustomersDto> getOrderDetail(int cid) throws SQLException;

	void updateQuantity(int orderId, int quantity) throws SQLException;

	void updateDiscount(int productId, double discount) throws SQLException;

	Products getPrice(int productId) throws SQLException,ProductNotFoundException;


}
