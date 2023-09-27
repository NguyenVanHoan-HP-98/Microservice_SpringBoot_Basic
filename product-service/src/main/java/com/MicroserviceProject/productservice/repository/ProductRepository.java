package com.MicroserviceProject.productservice.repository;


import com.MicroserviceProject.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
