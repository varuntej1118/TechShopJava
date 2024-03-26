package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDetailsDao;
import com.dao.OrderDetailsDaoImp;
import com.dto.OrderDetailsOfCustomersDto;
import com.exception.ProductNotFoundException;
import com.model.Products;

public class OrderDetailService {
	OrderDetailsDao orderDetailDao=new OrderDetailsDaoImp();
	
	public List<OrderDetailsOfCustomersDto> getOrderDetail( int cid) throws SQLException{
		
		return orderDetailDao.getOrderDetail(cid);
		
	}

	public double getTotalAmount(List<OrderDetailsOfCustomersDto> list) {
		double totalAmount=0;
		for (OrderDetailsOfCustomersDto o:list) {
			totalAmount+=o.getTotalAmount();
		}
		return totalAmount;
	}

	public void updateQuantity(int orderId, int quantity) throws SQLException {
		orderDetailDao.updateQuantity(orderId,quantity);
	}

	public void updateDiscount(int productId, double discount) throws SQLException {
		orderDetailDao.updateDiscount(productId,discount);
	}

	public Products getPrice(int productId) throws SQLException, ProductNotFoundException {

		return orderDetailDao.getPrice(productId);
	}
}
