package com.example.productservice.repositories;

import com.example.productservice.dtos.ProductRequestDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
		Optional<Product> findById(Long id);
		Optional<Product> findByTitleAndDescription(String title,String description);
		List<Product> findByTitleContaining(String word);
		//Behind the scene using like operator
		List<Product> findTopThreeByTitle(String title);
		Optional<Product> findByCategory(Category category);
		void deleteById(Long id);
		void deleteByTitle(String title);
		Product save(ProductRequestDto productRequestDto);

}

/*
	C --> Create
	R --> Read
	U --> Update
	D --> Delete

	create, Update --> save();
	Product save(Product product );

	ProductRepository --> Product
	Product findById(id) -->   Select * from Product where id = <id>;
	List<Products>  findALl() -->  Select * from Product
	Product findByTitle(String title) --> Select * from Product where title = <title>;

	this is what is done by Jpa internally
 */