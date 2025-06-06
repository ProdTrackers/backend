package com.lockitem.storeManagement.mapper;

import com.lockitem.storeManagement.dto.StoreRequestDTO;
import com.lockitem.storeManagement.dto.StoreResponseDTO;
import com.lockitem.storeManagement.entity.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    Store toEntity(StoreRequestDTO dto);
    StoreResponseDTO toDTO(Store store);
}
