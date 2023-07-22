package com.example.spring_security.event.listener;

import com.example.spring_security.event.RegistrationCompleteEvent;
import com.example.spring_security.user.User;
import com.example.spring_security.user.UserService;
import com.example.spring_security.user.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create verification token for the user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user,token);
        // send mail to user
        String url = event.getApplicationUrl() +
                "/verifyRegistration?token="+
                token;
        //send VerificationEmail()
        log.info("Click the link to verify your account: {}",url);
    }
}
