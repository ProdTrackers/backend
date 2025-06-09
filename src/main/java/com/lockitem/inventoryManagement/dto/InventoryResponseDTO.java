package com.lockitem.inventoryManagement.dto;

import com.lockitem.iotDevice.dto.IotDeviceResponseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponseDTO {
    public Long id;
    public String name;
    public String color;
    public String size;
    public String imageUrl;
    public Double price;
    // @JsonIgnore -> Uncomment if you want to hide status in the response
    public Long storeId;
    public IotDeviceResponseDTO iotDevice;
}