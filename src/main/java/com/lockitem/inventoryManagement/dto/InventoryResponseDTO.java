package com.lockitem.inventoryManagement.dto;

import lombok.Data;

@Data
public class InventoryResponseDTO {
    public Long id;
    public String name;
    public String color;
    public String size;
    public String imageUrl;
    public Double price;
    public Long storeId;
}