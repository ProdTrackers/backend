package com.lockitem.userProfile.controller;

import com.lockitem.userProfile.dto.LoginRequestDTO;
import com.lockitem.userProfile.dto.UserRequestDTO;
import com.lockitem.userProfile.dto.UserResponseDTO;
import com.lockitem.userProfile.entity.User;
import com.lockitem.userProfile.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    @Operation(summary = "Listar todos los usuarios")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<UserResponseDTO> users = userService.findAll().stream().map(user -> {
            UserResponseDTO dto = new UserResponseDTO();
            dto.id = user.getId();
            dto.firstName = user.getFirstName();
            dto.lastName = user.getLastName();
            dto.email = user.getEmail();
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    @Operation(summary = "Regsitro de usuario")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        User user = new User();
        user.setFirstName(dto.firstName);
        user.setLastName(dto.lastName);
        user.setEmail(dto.email);
        user.setPassword(dto.password);

        User saved = userService.createUser(user);
        UserResponseDTO response = new UserResponseDTO();
        response.id = saved.getId();
        response.firstName = saved.getFirstName();
        response.lastName = saved.getLastName();
        response.email = saved.getEmail();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return userService.findByEmailAndPassword(dto.email, dto.password)
                .map(user -> {
                    UserResponseDTO response = new UserResponseDTO();
                    response.id = user.getId();
                    response.firstName = user.getFirstName();
                    response.lastName = user.getLastName();
                    response.email = user.getEmail();
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.status(401).build());
    }
}
