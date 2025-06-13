package com.lockitem.reservationManagement.interfaces.controller;

import com.lockitem.reservationManagement.application.dto.ReservationRequestDTO;
import com.lockitem.reservationManagement.application.dto.ReservationResponseDTO;
import com.lockitem.reservationManagement.application.service.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva reserva")
    public ResponseEntity<ReservationResponseDTO> create(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO createdReservation = reservationService.create(reservationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalles de reserva por ID")
    public ResponseEntity<ReservationResponseDTO> getById(@PathVariable Long id) {
        return reservationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todas las reservas")
    public ResponseEntity<List<ReservationResponseDTO>> findAll() {
        List<ReservationResponseDTO> reservations = reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }
}
