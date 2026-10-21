package com.example.productservice.controllers;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.exceptions.ProductControllerSpecificException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.SocketOption;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws InvalidProductIdException {
         //Call the fakestore API to get the product with given Id here
//        throw new RuntimeException("Something went wrong Kartik ");
//        Product product = null;
//        try {
//            product = productService.getProductById(id);
//        } catch(RuntimeException e) {
//            System.out.println("Something went wrong");
//            return new ResponseEntity<>(p roduct,HttpStatus.NOT_FOUND);
//        }
       Product product = productService.getProductById(id);
      return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto){
    return productService.createProduct(productRequestDto);
     }
     //Partial Update
    @PatchMapping("/{id}")
     public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto){
        return productService.updateProduct(id, productRequestDto);
     }
     //Replace a Product
    @PutMapping("/{id}")
     public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto productRequestDto){
        return productService.replaceProduct(id,productRequestDto);
     }
     @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
     }

     @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException(){
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }

}
