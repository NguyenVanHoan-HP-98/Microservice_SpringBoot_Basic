package com.MicroserviceProject.inventoryservice.repository;

import com.MicroserviceProject.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    //Optional<Inventory> findBySkuCode(List<String> skucode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
