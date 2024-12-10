package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;


	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	public void addProduct(Product product) {
//		Product product = new Product();
//		product.setDescription(description);
//		product.setPrice(price);
//		product.setQuantity(qunatity);;
//		product.setTitle(title);
	
		productRepository.addProduct(product);
	}



	public List<Product> findAll(){
		return productRepository.findAll();
	}



	public void deleteProduct(int id) {
		 productRepository.deleteProduct(id);;	
	}
	
	public Product findById(int id) {
		
		return productRepository.findById(id);
	}

	public void updateProduct(Product product) {
//		Product product = productRepository.findById(id);
//		product.setTitle(title);
//        product.setDescription(description);
//        product.setQuantity(quantity);
//        product.setPrice(price);
        productRepository.updateProduct(product); 
		
		
	}






	


}
