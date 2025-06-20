package com.lockitem.iotDevice.service;

import com.lockitem.inventoryManagement.entity.Inventory;
import com.lockitem.inventoryManagement.repository.InventoryRepository;
import com.lockitem.iotDevice.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.dto.IotDeviceResponseDTO;
import com.lockitem.iotDevice.entity.IotDevice;
import com.lockitem.iotDevice.mapper.IotDeviceMapper;
import com.lockitem.iotDevice.repository.IotDeviceRepository;
import com.lockitem.reservationManagement.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IotDeviceServiceImpl implements IIotDeviceService {

    private final IotDeviceRepository iotDeviceRepository;
    private final IotDeviceMapper iotDeviceMapper;
    private final InventoryRepository inventoryRepository;
    private final ReservationRepository reservationRepository;

    public IotDeviceServiceImpl(IotDeviceRepository iotDeviceRepository,
                                IotDeviceMapper iotDeviceMapper,
                                InventoryRepository inventoryRepository,
                                ReservationRepository reservationRepository) {
        this.iotDeviceRepository = iotDeviceRepository;
        this.iotDeviceMapper = iotDeviceMapper;
        this.inventoryRepository = inventoryRepository;
        this.reservationRepository = reservationRepository;
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

    @Override
    public boolean isDeviceReserved(Long id) {
        IotDevice device = iotDeviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("IoT device not found with ID: " + id));

        Inventory inventory = device.getInventory();

        return reservationRepository.existsByInventory(inventory);
    }
}
