package com.lockitem.inventoryManagement.application.service;

import com.lockitem.inventoryManagement.application.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.application.dto.InventoryResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IInventoryService {
    InventoryResponseDTO create(InventoryRequestDTO inventoryRequestDTO);
    Optional<InventoryResponseDTO> findById(Long id);
    List<InventoryResponseDTO> findAll();
}