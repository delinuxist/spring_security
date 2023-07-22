package com.example.spring_security.user.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record UserRequestDTO(
        @NotNull
        @NotBlank
        String firstName,
        @NotNull
        @NotBlank
        String lastName,
        @NotNull
        @NotBlank
        @Email(message = "Invalid email")
        String email,
        @NotNull
        @NotBlank
        @Length(max = 60,min = 8)
        String password,
        String matchingPassword
) {
}
