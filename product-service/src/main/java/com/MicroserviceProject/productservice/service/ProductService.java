package com.MicroserviceProject.productservice.service;



import com.MicroserviceProject.productservice.dto.ProductRequest;
import com.MicroserviceProject.productservice.dto.ProductResponse;
import com.MicroserviceProject.productservice.model.Product;
import com.MicroserviceProject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private  final ProductRepository productRepository;

    public void  createProduct(@NotNull ProductRequest productRequest)
    {
        Product product = Product.builder()
                .product_id(productRequest.getProduct_id())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getProduct_id());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
       return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(@NotNull Product product)
    {
        return ProductResponse.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
