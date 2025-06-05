package com.lockitem.userProfile.controller;

import com.lockitem.userProfile.dto.LoginRequestDTO;
import com.lockitem.userProfile.dto.UserRequestDTO;
import com.lockitem.userProfile.dto.UserResponseDTO;
import com.lockitem.userProfile.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @Operation(summary = "Listar todos los usuarios")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    @Operation(summary = "Registrar un nuevo usuario")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO savedUser = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser); // Devolver 201 Created para creación exitosa
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        Optional<UserResponseDTO> authenticatedUser = userService.authenticate(dto);

        return authenticatedUser
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()); // Devolver 401 Unauthorized si falla la autenticación
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Devolver 404 Not Found si no se encuentra
    }
}
