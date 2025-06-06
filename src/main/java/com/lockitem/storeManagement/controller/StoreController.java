package com.lockitem.storeManagement.controller;

import com.lockitem.storeManagement.dto.StoreRequestDTO;
import com.lockitem.storeManagement.dto.StoreResponseDTO;
import com.lockitem.storeManagement.service.IStoreService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final IStoreService storeService;

    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar nueva tienda")
    public ResponseEntity<StoreResponseDTO> create(@Valid @RequestBody StoreRequestDTO dto) {
        StoreResponseDTO savedStore = storeService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStore);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle de tienda por ID")
    public ResponseEntity<StoreResponseDTO> getById(@PathVariable Long id) {
        return storeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Devolver 404 Not Found
    }

    @GetMapping("/all")
    @Operation(summary = "Listar todas las tiendas")
    public ResponseEntity<List<StoreResponseDTO>> findAll() {
        List<StoreResponseDTO> stores = storeService.findAll();
        return ResponseEntity.ok(stores);
    }
}