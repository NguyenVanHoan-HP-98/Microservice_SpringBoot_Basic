package com.MicroserviceProject.oderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long orderId;
    private List<OrderLineItemsDto> orderLineItems;
}
