package com.MicroserviceProject.productservice.controller;


import com.MicroserviceProject.productservice.dto.ProductRequest;
import com.MicroserviceProject.productservice.dto.ProductResponse;
import com.MicroserviceProject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void createProduct(@RequestBody ProductRequest productRequest ){
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus
    public List<ProductResponse> getAllProducts()
    {

        return   productService.getAllProducts();
    }
}
