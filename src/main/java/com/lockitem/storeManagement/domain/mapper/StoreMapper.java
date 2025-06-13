package com.lockitem.storeManagement.domain.mapper;

import com.lockitem.storeManagement.application.dto.StoreRequestDTO;
import com.lockitem.storeManagement.application.dto.StoreResponseDTO;
import com.lockitem.storeManagement.domain.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    Store toEntity(StoreRequestDTO dto);
    @Mapping(source = "inventories", target = "inventoryList")
    StoreResponseDTO toDTO(Store store);
}
