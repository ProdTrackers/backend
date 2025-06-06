package com.lockitem.storeManagement.service;

import com.lockitem.storeManagement.dto.StoreRequestDTO;
import com.lockitem.storeManagement.dto.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IStoreService {
    StoreResponseDTO create(StoreRequestDTO storeRequestDTO);
    Optional<StoreResponseDTO> findById(Long id);
    List<StoreResponseDTO> findAll();
    // StoreResponseDTO update(Long id, StoreRequestDTO storeRequestDTO);
    // void delete(Long id);
}
