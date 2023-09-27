package com.MicroserviceProject.inventoryservice.controller;

import com.MicroserviceProject.inventoryservice.dto.InventoryResponse;
import com.MicroserviceProject.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    //http://localhost:8082/api/inventory?skuCode=samsung&skuCode=iphone
   // @GetMapping("/{sku-code}")
    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    //public boolean isInStock(@PathVariable("sku-code") String skuCode)
    //{
        //return inventoryService.isInStock(skuCode);
    //}
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)
    {
        return inventoryService.isInStock(skuCode);
    }
}
