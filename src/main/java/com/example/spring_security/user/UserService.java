package com.example.spring_security.user;

import com.example.spring_security.user.dto.UserRequestDTO;
import com.example.spring_security.user.dto.UserResponseDTO;
import com.example.spring_security.user.dto.UserResponseDTOMapper;
import com.example.spring_security.verificationToken.VerificationToken;
import com.example.spring_security.verificationToken.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceDAO{

    private final UserRepository userRepository;

    private final VerificationTokenRepository verificationTokenRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserResponseDTOMapper userResponseDTOMapper;

    @Override
    public User register(UserRequestDTO userRequest) {
        User user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .role("USER")
                .password(passwordEncoder.encode(userRequest.password()))
                .build();
        return userRepository.save(user);
    }

    @Override
    public void saveVerificationTokenForUser(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(user,token);
        verificationTokenRepository.save(verificationToken);
    }
}
