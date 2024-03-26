package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.dto.InventoryProductDto;
import com.exception.ProductNotFoundException;
import com.model.Products;
import com.service.InventoryService;

public class InvController {
	public static void main(String[] args) {
		InventoryService inventoryService = new InventoryService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to Get Product");
			System.out.println("Enter 2 to Get Quantity In Stock");
			System.out.println("Enter 3 to Add To Inventory");
			System.out.println("Enter 4 to Remove To Inventory");
			System.out.println("Enter 5 to Update Quantity In Stock");
			System.out.println("Enter 6 to List All Products");
			System.out.println("Enter 0 to Exit");
			int input = sc.nextInt();
			if (input == 0) {
				break;
			}
			switch (input) {
			case 1:
				System.out.println("Enter Product ID to Get Details");
				int productId = sc.nextInt();
				InventoryProductDto p;
				try {
					p = inventoryService.getProduct(productId);
					System.out.println(p.getProductId() + "  " + p.getProductName() + "  " + p.getProductPrice() + "  "
							+ p.getQuantityInStock());

				} catch (SQLException | ProductNotFoundException e) {
					e.printStackTrace();
				}

				break;
			case 2:
				System.out.println("Enter Product ID to Get Details");
				productId = sc.nextInt();

				try {
					p = inventoryService.getProduct(productId);
					System.out.println(p.getProductId() + "  " + p.getProductName() + "  " + p.getQuantityInStock());

				} catch (SQLException | ProductNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter the Product Name ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.println("Enter the Product Description");
				String productDescription = sc.nextLine();
				System.out.println("Enter the Product Price");
				double productPrice = sc.nextDouble();
				try {
					inventoryService.insertProduct(productName, productDescription, productPrice);
					Products p1 = inventoryService.getProductId(productName);
					System.out.println("Enter No thr Quantity ");
					int quantity = sc.nextInt();
					inventoryService.insertInventory(p1.getId(), LocalDate.now(), quantity);
					System.out.println("Product and Inventory updated");

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				System.out.println("All Products ");
				List<InventoryProductDto> list;
				try {
					list = inventoryService.getAllProducts();
					for (InventoryProductDto p1 : list) {
						System.out.println(p1.getProductId() + "  " + p1.getProductName() + "  " + p1.getQuantityInStock());
					}
					System.out.println("Enter Product ID to delete");
					int id=sc.nextInt();
					inventoryService.deleteInventory(id);
					inventoryService.deleteProduct(id);
					System.out.println("Product Has Been Removed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				

				break;
			case 5:
				System.out.println("All Products ");
				try {
					list = inventoryService.getAllProducts();
					for (InventoryProductDto p1 : list) {
						System.out.println(p1.getProductId() + "  " + p1.getProductName() + "  " + p1.getQuantityInStock());
					}
					System.out.println("Enter Product ID to Update");
					int id=sc.nextInt();
					System.out.println("Enter No Of Quantity");
					int quantity=sc.nextInt();
					inventoryService.updateStock(id,LocalDate.now(),quantity);
					System.out.println("Update Done");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			
			case 6:
				System.out.println("All Products ");
				try {
					list = inventoryService.getAllProducts();
					for (InventoryProductDto p1 : list) {
						System.out.println(p1.getProductId() + "  " + p1.getProductName() + "  " + p1.getQuantityInStock());
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			
			}
		}
		sc.close();

	}

}
