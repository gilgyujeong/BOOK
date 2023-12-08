package com.example.book.service;

import com.example.book.dto.request.RequestSignupDto;
import com.example.book.dto.response.ResponseStatusDto;
import com.example.book.entity.User;
import com.example.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.book.entity.HttpStatusEnum.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public ResponseStatusDto signup(RequestSignupDto requestSignupDto) {
        User user = User.builder()
                .username(requestSignupDto.getUsername())
                .password(requestSignupDto.getPassword())
                .role(requestSignupDto.getRole())
                .build();

        userRepository.save(user);

        return ResponseStatusDto.builder()
                .message(OK.getMessage())
                .statusCode(OK.getStatusCode())
                .build();
    }
}
