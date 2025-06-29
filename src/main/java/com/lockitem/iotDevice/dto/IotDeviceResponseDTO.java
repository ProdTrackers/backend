package com.lockitem.iotDevice.dto;

import lombok.Data;

@Data
public class IotDeviceResponseDTO {
    Long id;
    double latitude;
    double longitude;
    Long inventoryId;
}
