package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

     private ProductService productService;

     ProductController(ProductService productService){
          this.productService = productService;
     }
    //localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
         //Call the fakestore API to get the product with given Id here
       return productService.getProductById(id);

    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return new ArrayList<>();
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
     public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
     }
     @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
     }
}
