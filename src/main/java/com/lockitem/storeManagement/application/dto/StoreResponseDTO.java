package com.lockitem.storeManagement.application.dto;

import com.lockitem.inventoryManagement.application.dto.InventoryResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StoreResponseDTO {
    public Long id;
    public String name;
    public List<InventoryResponseDTO> inventoryList;
}