package com.MicroserviceProject.oderservice.service;

import com.MicroserviceProject.oderservice.dto.InventoryResponse;
import com.MicroserviceProject.oderservice.dto.OrderLineItemsDto;
import com.MicroserviceProject.oderservice.dto.OrderRequest;
import com.MicroserviceProject.oderservice.model.Order;
import com.MicroserviceProject.oderservice.model.OrderLineItems;
import com.MicroserviceProject.oderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepository orderRepository;
    private  final WebClient.Builder webClientBuilder;

    Long order_item_id = Long.valueOf(0);
    private static boolean containsName(InventoryResponse[] array, String name) {
        for (InventoryResponse inventoryResponse : array) {
            if (inventoryResponse.getSkuCode().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void  placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderId(orderRequest.getOrderId());
        order_item_id = orderRequest.getOrderId();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems =  orderRequest.getOrderLineItems()
                .stream()
                .map(this::mapToDto)
               .toList();
      order.setOrderLineItems(orderLineItems);

     List<String> skuCodes =  order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).toList();
      //call Inventory Service, and place order if product is in stock
      InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
              .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
              .retrieve()
              .bodyToMono(InventoryResponse[].class)
              .block();
        boolean allProductsInStock = skuCodes.stream().allMatch(skuCode -> containsName(inventoryResponsesArray, skuCode));
        //boolean allProductsInStock =  Arrays.stream(inventoryResponsesArray).allMatch(InventoryResponse::isInStock);
      if(allProductsInStock) {
          orderRepository.save(order);
      }
      else {
          throw  new IllegalArgumentException("Product is not in stock, please try gain later");
      }
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto)
    {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setOrderItemId(orderLineItemsDto.getOrderItemId());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setOrderId(order_item_id);
        return  orderLineItems;
    }
}
