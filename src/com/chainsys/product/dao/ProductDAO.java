package com.chainsys.product.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	List<String> findAllName();

//	Product findByDate(String date);
	
	Product findById(int id);
	
	Product findByName(String name);

	void save(Product product);

	void update(Product product);
	
	void update_expiry (Product product);

	void delete(int id);

	Product findByDate(LocalDate date);

	void delete(LocalDate date);
}
