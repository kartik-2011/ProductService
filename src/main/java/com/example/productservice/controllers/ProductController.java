package com.example.productservice.controllers;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

     private final ProductService productService;

     ProductController(ProductService productService){
          this.productService = productService;
     }
    //localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product > getProductById(@PathVariable("id") Long id){
         //Call the fakestore API to get the product with given Id here
      Product product = productService.getProductById(id);
      return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
 
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
    return new Product();
     }
     //Partial Update
    @PatchMapping("/{id}")
     public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
     }
     //Replace a Product
    @PutMapping("/{id}")
     public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto){
        return productService.replaceProduct(id,productRequestDto);
     }
     @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
     }
}
