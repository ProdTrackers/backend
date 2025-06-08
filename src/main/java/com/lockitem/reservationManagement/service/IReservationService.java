package com.lockitem.reservationManagement.service;

import com.lockitem.reservationManagement.dto.ReservationRequestDTO;
import com.lockitem.reservationManagement.dto.ReservationResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IReservationService {
    ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO);
    Optional<ReservationResponseDTO> findById(Long id);
    List<ReservationResponseDTO> findAll();
}
