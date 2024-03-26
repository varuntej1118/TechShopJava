package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustDaoImp;
import com.exception.CustomerNotFoundException;
import com.model.Customers;
import com.model.Orders;

public class CustomerService {
	CustDaoImp customerDaoImpl=new CustDaoImp();
	public List<Orders> calculateTotalOrders(int id) throws SQLException {
		// TODO Auto-generated method stub
		return customerDaoImpl.calculateTotalOrders(id);
	}
	public Customers validateCustomer(int id) throws SQLException, CustomerNotFoundException {
		return customerDaoImpl.validateCustomer(id);
	}
	public Customers getCustomerDetails(int cid) throws SQLException, CustomerNotFoundException {
		return customerDaoImpl.getCustomerDetails(cid);
	}
	public void updateEmail(int cid1, String email) throws SQLException {
		customerDaoImpl.updateEmail(cid1,email);
	}
	public void updatePhone(int cid1, String phoneNo) throws SQLException {
		customerDaoImpl.updatePhone(cid1,phoneNo);
	}
	public void updateAddress(int cid1, String address) throws SQLException{
		customerDaoImpl.updateAddress(cid1,address);
	}

}
