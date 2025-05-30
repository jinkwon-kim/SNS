package com.spring.sns.auth.service;

import com.spring.sns.auth.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    //속성
    private final LoginRepository loginRepository;

    //생성자
    public LoginService (LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    //기능


}



