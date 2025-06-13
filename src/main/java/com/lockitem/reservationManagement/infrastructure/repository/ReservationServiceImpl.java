package com.lockitem.reservationManagement.infrastructure.repository;

import com.lockitem.inventoryManagement.domain.entity.Inventory;
import com.lockitem.inventoryManagement.domain.repository.InventoryRepository;
import com.lockitem.reservationManagement.application.dto.ReservationRequestDTO;
import com.lockitem.reservationManagement.application.dto.ReservationResponseDTO;
import com.lockitem.reservationManagement.domain.entity.Reservation;
import com.lockitem.reservationManagement.domain.mapper.ReservationMapper;
import com.lockitem.reservationManagement.domain.repository.ReservationRepository;
import com.lockitem.reservationManagement.application.service.IReservationService;
import com.lockitem.userProfile.domain.entity.User;
import com.lockitem.userProfile.domain.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final UserRepository userRepository;
    private final InventoryRepository inventoryRepository;

    // Inyección por constructor con los nuevos repositorios
    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationMapper reservationMapper,
                                  UserRepository userRepository,
                                  InventoryRepository inventoryRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO) {
        User user = userRepository.findById(reservationRequestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + reservationRequestDTO.getUserId() + " not found"));
        Inventory inventory = inventoryRepository.findById(reservationRequestDTO.getInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("Inventory item with ID " + reservationRequestDTO.getInventoryId() + " not found"));
        Reservation reservation = reservationMapper.toEntity(reservationRequestDTO);
        reservation.setUser(user);
        reservation.setInventory(inventory);
        reservation.setReservationTime(LocalDateTime.now());
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(savedReservation);
    }

    @Override
    public Optional<ReservationResponseDTO> findById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDTO);
    }

    @Override
    public List<ReservationResponseDTO> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }
}