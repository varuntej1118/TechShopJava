package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrdersDao;
import com.dao.OrdersDaoImp;
import com.dto.OrderDetailsOfCustomersDto;
import com.exception.InventoryNotFoundException;
import com.exception.OrderNotFoundException;
import com.model.Inventory;

public class OrderService {
	OrdersDao ordersDao=new OrdersDaoImp();

	public List<OrderDetailsOfCustomersDto> getOrderDetailsOfCustomer(int cid) throws SQLException {
		return ordersDao.getOrderDetailsOfCustomer(cid);
	}

	public double getTotalAmount(List<OrderDetailsOfCustomersDto> list) {
		double totalAmount=0;
		for (OrderDetailsOfCustomersDto od:list) {
			totalAmount+=od.getTotalAmount();
		}
		return totalAmount;
	}

	public OrderDetailsOfCustomersDto getOrderDeatils(int orderId) throws SQLException, OrderNotFoundException {
		return ordersDao.getOrderDeatils(orderId);
	}

	public void updateQuantityInstock(int productId, int quantity, int inventoryQuantity) throws SQLException {
		ordersDao.updateQuantityInstock(productId,quantity+inventoryQuantity);
	}

	public Inventory getInventoryDetails(int productId) throws SQLException, InventoryNotFoundException {
		return ordersDao.getInventoryDetails(productId);
	}

	public void deleteOrderDetail(int orderId) throws SQLException {
		ordersDao.deleteOrderDetail(orderId);
	}

	public void deleteOrder(int orderId) throws SQLException {
		ordersDao.deleteOrder(orderId);
	}

}
