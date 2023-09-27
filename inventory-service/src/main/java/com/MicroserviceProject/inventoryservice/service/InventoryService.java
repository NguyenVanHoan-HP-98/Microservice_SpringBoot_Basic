package com.MicroserviceProject.inventoryservice.service;

import com.MicroserviceProject.inventoryservice.dto.InventoryResponse;
import com.MicroserviceProject.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private  final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    //public  boolean isInStock(List<String> skuCode)
   // {
      // return inventoryRepository.findBySkuCodeIn(skuCode).isPresent();
    //}
    public  List<InventoryResponse> isInStock(List<String> skuCode)
    {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
