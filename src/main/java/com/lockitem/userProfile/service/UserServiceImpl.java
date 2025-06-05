package com.lockitem.userProfile.service;

import com.lockitem.userProfile.dto.LoginRequestDTO;
import com.lockitem.userProfile.dto.UserRequestDTO;
import com.lockitem.userProfile.dto.UserResponseDTO;
import com.lockitem.userProfile.entity.User;
import com.lockitem.userProfile.mapper.UserMapper;
import com.lockitem.userProfile.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserResponseDTO> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequestDTO.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
                return Optional.of(userMapper.toDTO(user));
            }
        }
        return Optional.empty(); // Autenticación fallida
    }

    @Override
    public Optional<UserResponseDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }
}
