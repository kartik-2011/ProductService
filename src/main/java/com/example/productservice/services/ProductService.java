package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService  {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct();
    Product updateProduct();
    Product replaceProduct();
    void deleteProduct();
}
