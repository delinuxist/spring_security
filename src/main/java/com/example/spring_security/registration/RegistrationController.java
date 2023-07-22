package com.example.spring_security.registration;

import com.example.spring_security.event.RegistrationCompleteEvent;
import com.example.spring_security.user.User;
import com.example.spring_security.user.UserService;
import com.example.spring_security.user.dto.UserRequestDTO;
import com.example.spring_security.user.dto.UserResponseDTO;
import com.example.spring_security.user.dto.UserResponseDTOMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    private final ApplicationEventPublisher publisher;

    private final UserResponseDTOMapper userResponseDTOMapper;

    @PostMapping()
    public UserResponseDTO registerUser(@RequestBody @Valid UserRequestDTO userRequest, final HttpServletRequest request) {
        User user = userService.register(userRequest);
        if(Objects.isNull(user)) {
            throw new IllegalStateException("Registration failed");
        }
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return userResponseDTOMapper.apply(user);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+
                request.getServerName()+
                ":"+
                request.getServerPort()+
                request.getContextPath();
    }
}
