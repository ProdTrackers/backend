package com.lockitem.inventoryManagement.service;

import com.lockitem.inventoryManagement.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.dto.InventoryResponseDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface IInventoryService {
    InventoryResponseDTO create(InventoryRequestDTO inventoryRequestDTO);
    Optional<InventoryResponseDTO> findById(Long id);
    List<InventoryResponseDTO> findAll();
}