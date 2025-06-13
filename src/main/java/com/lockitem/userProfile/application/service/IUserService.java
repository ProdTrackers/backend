package com.lockitem.userProfile.application.service;

import com.lockitem.userProfile.application.dto.LoginRequestDTO;
import com.lockitem.userProfile.application.dto.UserRequestDTO;
import com.lockitem.userProfile.application.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    Optional<UserResponseDTO> authenticate(LoginRequestDTO loginRequestDTO); // Método para autenticación segura
    Optional<UserResponseDTO> findById(Long id);
}