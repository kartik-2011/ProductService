package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
     private final RestTemplate restTemplate;
     FakeStoreProductService(RestTemplate restTemplate){
         this.restTemplate =  restTemplate;
     }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        //PUT Method
        //Replace the product with given id with the input product
        //and return the updated product in ht output 
         restTemplate.put("https://fakestoreapi.com/products/"+ id, product);
         return getProductById(id);
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
         FakeStoreProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products/" , FakeStoreProductDto[].class);

        if(products == null) {
            return new ArrayList<>();
        }
         List<Product> result = new ArrayList<>();
         for(FakeStoreProductDto dto: products){
            result.add(convertFakeStoreProductDtoToProduct(dto));
         }
        return result;
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto =
         restTemplate.getForObject("https://fakestoreapi.com/products/" +id , FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
              return null;
        //Convert fakeStoreProductDto to product object.
            return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
}
