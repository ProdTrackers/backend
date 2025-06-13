package com.lockitem.inventoryManagement.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InventoryRequestDTO {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    private String color;
    private String size;
    private String imageUrl;
    private Double price;
    @NotNull(message = "Store ID cannot be null")
    private Long storeId;

}
