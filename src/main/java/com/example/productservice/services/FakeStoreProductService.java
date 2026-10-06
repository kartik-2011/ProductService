package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class FakeStoreProductService implements ProductService{
     private final RestTemplate restTemplate;
     FakeStoreProductService(RestTemplate restTemplate){
         this.restTemplate =  restTemplate;
     }
    public Product convertProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setId(productRequestDto.getId());
        product.setImage(productRequestDto.getImage());
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        Category category = new Category();
        category.setTitle(productRequestDto.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product replaceProduct(Long id, ProductRequestDto productRequestDto) {
        //PUT Method
        //Replace the product with given id with the input product
        //and return the updated product in ht output

        //Convert ProductRequestDto to the actual Product
        Product product = convertProductRequestDtoToProduct(productRequestDto);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product ,ProductRequestDto.class);
        HttpMessageConverterExtractor<ProductRequestDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductRequestDto.class, restTemplate.getMessageConverters());
        ProductRequestDto dto =  restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        if(dto == null)
            return null;
        //Convert productRequestDto to product object.
        return convertProductRequestDtoToProduct(dto);
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
         ProductRequestDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products/" , ProductRequestDto[].class);

        if(products == null) {
            return new ArrayList<>();
        }
         List<Product> result = new ArrayList<>();
         for(ProductRequestDto dto: products){
            result.add(convertProductRequestDtoToProduct(dto));
         }
        return result;
    }

    @Override
    public Product getProductById(Long id) {
        ProductRequestDto productRequestDto =
         restTemplate.getForObject("https://fakestoreapi.com/products/" +id , ProductRequestDto.class);
        if(productRequestDto == null)
              return null;
        //Convert productRequestDto to product object.
            return convertProductRequestDtoToProduct(productRequestDto);
    }
}
