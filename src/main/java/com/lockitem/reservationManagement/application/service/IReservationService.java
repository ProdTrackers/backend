package com.lockitem.reservationManagement.application.service;

import com.lockitem.reservationManagement.application.dto.ReservationRequestDTO;
import com.lockitem.reservationManagement.application.dto.ReservationResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IReservationService {
    ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO);
    Optional<ReservationResponseDTO> findById(Long id);
    List<ReservationResponseDTO> findAll();
}
