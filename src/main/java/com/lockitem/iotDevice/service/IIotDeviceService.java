package com.lockitem.iotDevice.service;

import com.lockitem.iotDevice.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.dto.IotDeviceResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IIotDeviceService {
    IotDeviceResponseDTO create(IotDeviceRequestDTO iotDeviceRequestDTO);
    Optional<IotDeviceResponseDTO> findById(Long id);
    List<IotDeviceResponseDTO> findAll();
    boolean isDeviceReserved(Long id);
    // Optional<IotDeviceResponseDTO> updateLocation(Long id, double latitude, double longitude);
    // void delete(Long id);
}
