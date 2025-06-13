package com.lockitem.inventoryManagement.interfaces.controller;

import com.lockitem.inventoryManagement.application.dto.InventoryRequestDTO;
import com.lockitem.inventoryManagement.application.dto.InventoryResponseDTO;
import com.lockitem.inventoryManagement.application.service.IInventoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final IInventoryService inventoryService;

    public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    @Operation(summary = "Registrar nuevo ítem")
    public ResponseEntity<InventoryResponseDTO> create(@Valid @RequestBody InventoryRequestDTO dto) {
        InventoryResponseDTO savedInventory = inventoryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInventory); // Devolver 201 Created
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener detalle por ID")
    public ResponseEntity<InventoryResponseDTO> getById(@PathVariable Long id) {
        return inventoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Devolver 404 Not Found
    }

    @GetMapping
    @Operation(summary = "Listar todo el inventario")
    public ResponseEntity<List<InventoryResponseDTO>> findAll() {
        List<InventoryResponseDTO> inventoryList = inventoryService.findAll();
        return ResponseEntity.ok(inventoryList);
    }
}
