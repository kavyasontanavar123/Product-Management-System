package com.example.product.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.product.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
@Repository
public class ProductRepository {
	private final EntityManagerFactory factory;

	public ProductRepository(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void addProduct(Product product) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(product);
		transaction.commit();
		manager.close();
	}

	public List<Product> findAll() {
		EntityManager manager = factory.createEntityManager();
	    TypedQuery<Product> query =  manager.createQuery("FROM Product",Product.class);
	    List<Product> products= query.getResultList();
	   
		manager.close();
		return products;
	}
	public void deleteProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Product products = manager.find(Product.class,id);
		manager.remove(products);
		transaction.commit();
		manager.close();
	}

	public Product findById(int id) {
		EntityManager manager = factory.createEntityManager();
        Product product = manager.find(Product.class, id);
        manager.close();
        return product;
		
	}

	public void updateProduct(Product product) {
		EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.merge(product); 
        transaction.commit();
        manager.close();
		
	}

	
}
