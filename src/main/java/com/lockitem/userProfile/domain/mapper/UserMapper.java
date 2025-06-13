package com.lockitem.userProfile.domain.mapper;

import com.lockitem.userProfile.application.dto.UserRequestDTO;
import com.lockitem.userProfile.application.dto.UserResponseDTO;
import com.lockitem.userProfile.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDTO(User user);
}
