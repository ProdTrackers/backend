package com.lockitem.inventoryManagement.domain.mapper;

import com.lockitem.inventoryManagement.application.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.application.dto.InventoryResponseDTO;
import com.lockitem.inventoryManagement.domain.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    Inventory toEntity(InventoryRequestDTO dto);

    @Mapping(source = "store.id", target = "storeId")
    @Mapping(source = "iotDevice", target = "iotDevice")
    InventoryResponseDTO toDTO(Inventory inventory);
}
