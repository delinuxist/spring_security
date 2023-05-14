package com.example.spring_security.user.dto;

import jakarta.validation.constraints.*;

public record UserRequestDTO(
        @NotNull
        @NotBlank
        String firstName,
        @NotNull
        @NotBlank
        String lastName,
        @NotNull
        @NotBlank
        @Email
        String email,
        @NotNull
        @NotBlank
        @Max(60)
        @Min(6)
        String password,
        String matchingPassword
) {
}
