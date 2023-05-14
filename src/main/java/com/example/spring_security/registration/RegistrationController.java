package com.example.spring_security.registration;

import com.example.spring_security.user.UserService;
import com.example.spring_security.user.dto.UserRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/register")
@RequiredArgsConstructor
public class RegistrationController {

    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDTO userRequest) {

        return ResponseEntity.ok().body("registration completed");
    }
}
