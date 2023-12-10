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
        if (requestSignupDto.getPassword() != requestSignupDto.getCheckPassword()) {
            throw new IllegalArgumentException("동일한 비밀번호가 아닙니다.");
        }

        User user = User.builder()
                .username(requestSignupDto.getUsername())
                .password(requestSignupDto.getPassword())
                .build();

        userRepository.save(user);

        return ResponseStatusDto.builder()
                .message(CREATED.getMessage())
                .statusCode(CREATED.getStatusCode())
                .build();
    }
}
