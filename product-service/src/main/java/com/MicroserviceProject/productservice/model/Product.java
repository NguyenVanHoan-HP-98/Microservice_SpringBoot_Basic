package com.MicroserviceProject.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private  String description;
    @Column(name = "price")
    private BigDecimal price;
}
