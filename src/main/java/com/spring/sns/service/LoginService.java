package com.spring.sns.service;

import com.spring.sns.config.PasswordEncoder;
import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.domain.User;
import com.spring.sns.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    //속성
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;


    //생성자
    public LoginService (LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //기능
    @Transactional
    public void login (LoginRequestDto requestDto) {
        //데이터 준비
        String userEmail = requestDto.getUserEmail();
        String password = requestDto.getPassword();
        //조회 및 검증
        User user = loginRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        //토큰 반환

    }
    }

