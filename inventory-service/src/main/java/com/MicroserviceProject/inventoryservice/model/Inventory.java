package com.MicroserviceProject.inventoryservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "INVENTORY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    private Long inventoryId;
    @Column(name = "skucode")
    private  String skuCode;
    @Column(name = "quantity")
    private Integer quantity;
}
