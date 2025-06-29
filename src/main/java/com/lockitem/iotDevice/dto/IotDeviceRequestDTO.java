package com.lockitem.iotDevice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IotDeviceRequestDTO {

    private double latitude;
    private double longitude;

    @NotNull(message = "Inventory ID cannot be null")
    private Long inventoryId;
}
