package com.chainsys.product.test;

import java.time.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) throws ProductNotFoundException {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		String name;
		
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		System.out.println(" 1. Find All Products \n 2. Find the Product By Id\n "
				+ "3. Find the Product By Name\n 4. Update the Product Name Based on the Id \n "
				+ "5. Update the Expiry date Based on the Id \n 6.Adding a Product \n 7. Deleting a Product\n"
				+ " 8. Find Name of All Products\n 9. Deleting a Product By Expiry Date\n 10."
				+ "Find the Product By Date\n 11. Deleting a Product by Name" );
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		List<String> nameList;
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
			
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 3:
			System.out.println("Find the Product By Name");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 4:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(4, "MicroPencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
			
		case 5:
			System.out.println("Update the Expiry date Based on the Id");
			date = "07/07/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product uppro = new Product(3, "Milk", LocalDate.parse(date, dateFormat));
			try {
				service.update_expire(uppro);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
			
		case 6:
			System.out.println("Adding a Product");
			date = "06/05/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
			
		case 7:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 8:
			System.out.println("Display Name of All Products");
			nameList = service.findAllName();
			System.out.println(nameList);
			break;
			
		case 9:
			System.out.println("Deleting a Product By Expiry Date");
			
			try {
				System.out.println("Enter the Product Expiry Date");
				date = scanner.next();
				dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

				service.delete(LocalDate.parse(date,dateFormat));
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 10:
			System.out.println("Find the Product By Date");
			System.out.println("Enter the Product Date");
			date = scanner.next();
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try {
				Product product = service.findByDate(LocalDate.parse(date,dateFormat));
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 11:
			System.out.println("Deleting a Product by Name");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.delete(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		default:
			break;

		}
		scanner.close();
	}

}
