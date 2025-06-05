package com.lockitem.userProfile.mapper;

import com.lockitem.userProfile.dto.UserRequestDTO;
import com.lockitem.userProfile.dto.UserResponseDTO;
import com.lockitem.userProfile.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDTO(User user);
}
