package com.lockitem.iotDevice.mapper;

import com.lockitem.iotDevice.dto.IotDeviceRequestDTO;
import com.lockitem.iotDevice.dto.IotDeviceResponseDTO;
import com.lockitem.iotDevice.entity.IotDevice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IotDeviceMapper {

    IotDeviceMapper INSTANCE = Mappers.getMapper(IotDeviceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    IotDevice toEntity(IotDeviceRequestDTO dto);

    @Mapping(source = "inventory.id", target = "inventoryId")
    IotDeviceResponseDTO toDTO(IotDevice iotDevice);
}
