package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.CustomerNotFoundException;
import com.model.Customers;
import com.model.Orders;
import com.service.CustomerService;

public class CustController {
	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter 1 to  get the number of orders placed by you");
			System.out.println("Enter 2 to get your info");
			System.out.println("Enter 3 to update your details");
			System.out.println("Enter 0 to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				break;
			}
			switch (input) {
			case 1:
				List<Orders> list = new ArrayList<Orders>();
				System.out.println("Enter your Customer ID ");
				int id = sc.nextInt();
				try {
					cs.validateCustomer(id);
					list = cs.calculateTotalOrders(id);
					System.out.println("Number of orders placed by Customer ID-" + id + " was " + list.size());
				} catch (SQLException | CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter the Customer ID ");
				int cid = sc.nextInt();
				Customers c = new Customers();
				try {
					c = cs.getCustomerDetails(cid);
					System.out.println(c);
				} catch (SQLException | CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter your Customer ID");
				int cid1 = sc.nextInt();

				System.out.println("Enter 1 to Update Email ID");
				System.out.println("Enter 2 to Update phone number");
				System.out.println("Enter 3 to Update address");
				int input1 = sc.nextInt();
				switch (input1) {
				case 1:
					System.out.println("Enter Email to update");
					sc.nextLine();
					String email = sc.nextLine();
					try {

						cs.updateEmail(cid1, email);
						System.out.println("Update Done");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter Phone number to update");
					sc.nextLine();
					String phoneNo = sc.nextLine();
					try {

						cs.updatePhone(cid1, phoneNo);
						System.out.println("Update Done");
					} catch (SQLException e) {
						e.printStackTrace();
					}

					break;
				case 3:
					System.out.println("Enter Address to updatew");
					sc.nextLine();
					String address = sc.nextLine();
					try {

						cs.updateAddress(cid1, address);
						System.out.println("Update Done");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				}
			}

		}
		sc.close();

	}
}
