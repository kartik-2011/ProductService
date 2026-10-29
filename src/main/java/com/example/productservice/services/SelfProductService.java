package com.example.productservice.services;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	@Override
	public Product getProductById(Long id) throws InvalidProductIdException {
		//Fetch product with the given id in Database;
		Optional<Product> optionalProduct =  productRepository.findById(id);
		if(optionalProduct.isEmpty()){
			//throw an exception --> Product not found
			return null;

		}
		return optionalProduct.get();

	}

	@Override
	public List<Product> getAllProducts() {
		//Fetch all the Products from database
		return List.of();
	}
	public Product convertProductRequestDtoToProduct(ProductRequestDto productRequestDto){
		Product product = new Product();

		product.setTitle(productRequestDto.getTitle());
		product.setPrice(productRequestDto.getPrice());
		product.setDescription(productRequestDto.getDescription());
		product.setImage(productRequestDto.getImage());
		product.setCategory(productRequestDto.getCategory());

		return productRepository.save(product);
	}

	@Override
	public Product createProduct(ProductRequestDto productRequestDto) {
		Category category = productRequestDto.getCategory();
		       if(category.getId() == null) {
				   //first save the category in the database
				   Category savedCategory = categoryRepository.save(category);
				   productRequestDto.setCategory(savedCategory);
			   }
			    convertProductRequestDtoToProduct(productRequestDto);
		return productRepository.save(convertProductRequestDtoToProduct(productRequestDto));

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
