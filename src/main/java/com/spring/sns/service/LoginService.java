package com.spring.sns.service;

import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.domain.Users;
import com.spring.sns.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService {
    //속성
    private final LoginRepository loginRepository;

    //생성자
    public LoginService (LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    //기능
    @Transactional
    public void login (LoginRequestDto requestDto) {
        //데이터 준비
        String userEmail = requestDto.getUserEmail();
        String password = requestDto.getPassword();
        //조회 및 검증
        Users user = loginRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if () {

        }
    }

}