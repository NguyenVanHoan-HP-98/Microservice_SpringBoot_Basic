package com.MicroserviceProject.oderservice.dto;

import com.MicroserviceProject.oderservice.model.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private  Long orderItemId;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
