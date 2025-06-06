package com.lockitem.inventoryManagement.service;

import com.lockitem.inventoryManagement.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.dto.InventoryResponseDTO;
import com.lockitem.inventoryManagement.entity.Inventory;
import com.lockitem.inventoryManagement.mapper.InventoryMapper;
import com.lockitem.inventoryManagement.repository.InventoryRepository;
import com.lockitem.storeManagement.entity.Store;
import com.lockitem.storeManagement.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements IInventoryService {

    private final InventoryRepository inventoryRepository;
    private final StoreRepository storeRepository;
    private final InventoryMapper inventoryMapper;

    // Inyección por constructor
    public InventoryServiceImpl(InventoryRepository inventoryRepository,
                                StoreRepository storeRepository,
                                InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.storeRepository = storeRepository;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public InventoryResponseDTO create(InventoryRequestDTO inventoryRequestDTO) {
        Store store = storeRepository.findById(inventoryRequestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store with ID " + inventoryRequestDTO.getStoreId() + " not found"));
        Inventory inventory = inventoryMapper.toEntity(inventoryRequestDTO);
        inventory.setStore(store);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return inventoryMapper.toDTO(savedInventory);
    }

    @Override
    public Optional<InventoryResponseDTO> findById(Long id) {
        return inventoryRepository.findById(id)
                .map(inventoryMapper::toDTO);
    }

    @Override
    public List<InventoryResponseDTO> findAll() {
        return inventoryRepository.findAll().stream()
                .map(inventoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}