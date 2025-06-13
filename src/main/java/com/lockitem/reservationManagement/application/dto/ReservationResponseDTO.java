package com.lockitem.reservationManagement.application.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReservationResponseDTO {
    Long id;
    Long userId;
    String userName;
    Long inventoryId;
    String inventoryName;
    LocalDateTime reservationTime;
}
