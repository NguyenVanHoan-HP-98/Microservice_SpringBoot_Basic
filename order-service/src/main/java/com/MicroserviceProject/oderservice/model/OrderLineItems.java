package com.MicroserviceProject.oderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderLineItems {
    @Id
    @Column(name = "orderitem_id")
    private  Long orderItemId;
    @Column(name = "skucode")
    private String skuCode;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "order_id")
    private Long orderId;
}
