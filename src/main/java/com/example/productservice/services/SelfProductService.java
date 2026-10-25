package com.example.productservice.services;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
public class SelfProductService implements ProductService{
	@Override
	public Product getProductById(Long id) throws InvalidProductIdException {
		//Fetch product with the given id in Database

		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		//Fetch all the Products from database
		return List.of();
	}

	@Override
	public Product createProduct(ProductRequestDto productRequestDto) {
		return null;
	}

	@Override
	public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
		return null;
	}

	@Override
	public Product replaceProduct(Long id, ProductRequestDto productRequestDto) {
		return null;
	}

	@Override
	public Product deleteProduct(Long id) {
		return null;
	}
}
