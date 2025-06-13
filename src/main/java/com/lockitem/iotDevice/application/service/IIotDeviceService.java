package com.lockitem.iotDevice.application.service;

import com.lockitem.iotDevice.application.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.application.dto.IotDeviceResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IIotDeviceService {
    IotDeviceResponseDTO create(IotDeviceRequestDTO iotDeviceRequestDTO);
    Optional<IotDeviceResponseDTO> findById(Long id);
    List<IotDeviceResponseDTO> findAll();

    // Optional<IotDeviceResponseDTO> updateLocation(Long id, double latitude, double longitude);
    // void delete(Long id);
}
