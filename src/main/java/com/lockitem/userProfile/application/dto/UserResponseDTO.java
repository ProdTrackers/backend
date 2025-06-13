package com.lockitem.userProfile.application.dto;

import lombok.Builder;

@Builder
public class UserResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
}
