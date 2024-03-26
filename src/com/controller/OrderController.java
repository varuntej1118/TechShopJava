package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.OrderDetailsOfCustomersDto;
import com.service.OrderService;

public class OrderController {
public static void main(String[] args) {
	OrderService orderService= new OrderService();
	Scanner sc = new Scanner(System.in);

	while (true) {
		System.out.println("Enter 1 to Calculate the Total amount of your orders");
		System.out.println("Enter 2 to Retrieve Order Details");
		System.out.println("Enter 0 to Exit");
		int input = sc.nextInt();
		if (input == 0) {
			break;
		}
		switch (input) {
		case 1:
			System.out.println("Enter your Customer ID ");
			int cid=sc.nextInt();
			List<OrderDetailsOfCustomersDto> list=new ArrayList<OrderDetailsOfCustomersDto>();
			try {
				list=orderService.getOrderDetailsOfCustomer(cid);
				for(OrderDetailsOfCustomersDto od:list) {
					System.out.println(od.getOrderId()+" "+od.getProductName()+" "+od.getTotalAmount()+" "+od.getQuantity());
				}
				
				System.out.println("Total Amount :" +orderService.getTotalAmount(list));
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
			
			
			
			break;
		case 2:
			System.out.println("Enter your Customer ID ");
			int cid1=sc.nextInt();
			try {
				list=orderService.getOrderDetailsOfCustomer(cid1);
				for(OrderDetailsOfCustomersDto od:list) {
					System.out.println(od.getOrderId()+" "+od.getProductName()+" "+od.getTotalAmount()+" "+od.getQuantity());
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			break;

			
		}
	}
	sc.close();
}


}
