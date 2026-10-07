package com.example.productservice.services;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Product;

import java.util.List;

public interface  ProductService  {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(ProductRequestDto productRequestDto);
    Product updateProduct(Long id, ProductRequestDto productRequestDto);
    Product replaceProduct(Long id, ProductRequestDto productRequestDto);
    Product deleteProduct(Long id);
}
