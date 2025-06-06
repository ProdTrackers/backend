package com.lockitem.inventoryManagement.mapper;

import com.lockitem.inventoryManagement.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.dto.InventoryResponseDTO;
import com.lockitem.inventoryManagement.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    Inventory toEntity(InventoryRequestDTO dto);

    @Mapping(source = "store.id", target = "storeId")
    InventoryResponseDTO toDTO(Inventory inventory);
}
