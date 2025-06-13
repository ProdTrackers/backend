package com.lockitem.storeManagement.application.service;

import com.lockitem.storeManagement.application.dto.StoreRequestDTO;
import com.lockitem.storeManagement.application.dto.StoreResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IStoreService {
    StoreResponseDTO create(StoreRequestDTO storeRequestDTO);
    Optional<StoreResponseDTO> findById(Long id);
    List<StoreResponseDTO> findAll();
    // StoreResponseDTO update(Long id, StoreRequestDTO storeRequestDTO);
    // void delete(Long id);
}
