package com.lockitem.userProfile.service;

import com.lockitem.userProfile.dto.LoginRequestDTO;
import com.lockitem.userProfile.dto.UserRequestDTO;
import com.lockitem.userProfile.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserResponseDTO> findAll();
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    Optional<UserResponseDTO> authenticate(LoginRequestDTO loginRequestDTO); // Método para autenticación segura
    Optional<UserResponseDTO> findById(Long id);
}