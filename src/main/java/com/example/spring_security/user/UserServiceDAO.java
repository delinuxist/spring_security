package com.example.spring_security.user;

import com.example.spring_security.user.dto.UserRequestDTO;
import com.example.spring_security.user.dto.UserResponseDTO;

public interface UserServiceDAO {
    User register(UserRequestDTO userRequest);

    void saveVerificationTokenForUser(User user, String token);
}

