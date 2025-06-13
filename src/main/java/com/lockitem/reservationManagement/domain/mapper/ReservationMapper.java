package com.lockitem.reservationManagement.domain.mapper;

import com.lockitem.reservationManagement.application.dto.ReservationRequestDTO;
import com.lockitem.reservationManagement.application.dto.ReservationResponseDTO;
import com.lockitem.reservationManagement.domain.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "inventory", ignore = true)
    @Mapping(target = "reservationTime", ignore = true)
    Reservation toEntity(ReservationRequestDTO dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userName")
    @Mapping(source = "inventory.id", target = "inventoryId")
    @Mapping(source = "inventory.name", target = "inventoryName")
    ReservationResponseDTO toDTO(Reservation reservation);

    // @Mapping(target = "id", ignore = true)
    // void updateEntityFromDto(ReservationRequestDTO dto, @MappingTarget Reservation entity);
}
