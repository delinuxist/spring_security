package com.example.spring_security.user.dto;

import com.example.spring_security.user.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserResponseDTOMapper implements Function<User,UserResponseDTO> {
    @Override
    public UserResponseDTO apply(User user) {
        return UserResponseDTO.builder()
                .Id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
