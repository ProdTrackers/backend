package com.lockitem.iotDevice.controller;

import com.lockitem.iotDevice.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.dto.IotDeviceResponseDTO;
import com.lockitem.iotDevice.service.IIotDeviceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/iot-devices")
public class IotDeviceController {

    private final IIotDeviceService iotDeviceService;

    public IotDeviceController(IIotDeviceService iotDeviceService) {
        this.iotDeviceService = iotDeviceService;
    }

    @PostMapping
    @Operation(summary = "Register a new IoT device")
    public ResponseEntity<IotDeviceResponseDTO> create(@Valid @RequestBody IotDeviceRequestDTO dto) {
        IotDeviceResponseDTO savedDevice = iotDeviceService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get IoT device details by ID")
    public ResponseEntity<IotDeviceResponseDTO> getById(@PathVariable Long id) {
        return iotDeviceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "List all IoT devices")
    public ResponseEntity<List<IotDeviceResponseDTO>> findAll() {
        List<IotDeviceResponseDTO> deviceList = iotDeviceService.findAll();
        return ResponseEntity.ok(deviceList);
    }

    @GetMapping("/{id}/is-reserved")
    public ResponseEntity<Boolean> isDeviceReserved(@PathVariable Long id) {
        boolean reserved = iotDeviceService.isDeviceReserved(id);
        return ResponseEntity.ok(reserved);
    }
}
