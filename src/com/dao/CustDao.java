package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.CustomerNotFoundException;
import com.model.Customers;
import com.model.Orders;

public interface CustDao {
	public List<Orders> calculateTotalOrders(int id) throws SQLException;
	public Customers validateCustomer(int id) throws SQLException, CustomerNotFoundException;
	public Customers getCustomerDetails(int cid) throws SQLException, CustomerNotFoundException;
	public void updateEmail(int cid1, String email) throws SQLException;
	public void updatePhone(int cid1, String phoneNo) throws SQLException;
	public void updateAddress(int cid1, String address) throws SQLException;
	


}
