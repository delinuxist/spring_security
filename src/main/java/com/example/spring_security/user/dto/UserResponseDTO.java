package com.example.spring_security.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
public record UserResponseDTO(
        Long Id,
        String firstName,
        String lastName,
        String email
) {
}

