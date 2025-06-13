package com.lockitem.iotDevice.infrastructure.repository;

import com.lockitem.inventoryManagement.domain.entity.Inventory;
import com.lockitem.inventoryManagement.domain.repository.InventoryRepository;
import com.lockitem.iotDevice.application.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.application.dto.IotDeviceResponseDTO;
import com.lockitem.iotDevice.application.service.IIotDeviceService;
import com.lockitem.iotDevice.domain.entity.IotDevice;
import com.lockitem.iotDevice.domain.mapper.IotDeviceMapper;
import com.lockitem.iotDevice.domain.repository.IotDeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IotDeviceServiceImpl implements IIotDeviceService {

    private final IotDeviceRepository iotDeviceRepository;
    private final IotDeviceMapper iotDeviceMapper;
    private final InventoryRepository inventoryRepository;

    public IotDeviceServiceImpl(IotDeviceRepository iotDeviceRepository,
                                IotDeviceMapper iotDeviceMapper,
                                InventoryRepository inventoryRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
        this.iotDeviceMapper = iotDeviceMapper;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public IotDeviceResponseDTO create(IotDeviceRequestDTO iotDeviceRequestDTO) {
        IotDevice iotDevice = iotDeviceMapper.toEntity(iotDeviceRequestDTO);
        Inventory inventory = inventoryRepository.findById(iotDeviceRequestDTO.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory item with ID " + iotDeviceRequestDTO.getInventoryId() + " not found"));
        iotDevice.setInventory(inventory);
        // iotDevice.setLatitude(0.0);
        // iotDevice.setLongitude(0.0);

        IotDevice savedIotDevice = iotDeviceRepository.save(iotDevice);
        return iotDeviceMapper.toDTO(savedIotDevice);
    }

    @Override
    public Optional<IotDeviceResponseDTO> findById(Long id) {
        return iotDeviceRepository.findById(id)
                .map(iotDeviceMapper::toDTO);
    }

    @Override
    public List<IotDeviceResponseDTO> findAll() {
        return iotDeviceRepository.findAll().stream()
                .map(iotDeviceMapper::toDTO)
                .collect(Collectors.toList());
    }
}
