package com.spring.sns.auth.controller;

import com.spring.sns.auth.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    //속성
    private final LoginService loginService;

    //생성자
    public LoginController (LoginService loginService) {
        this.loginService = loginService;
    }

    //기능
    /**
     * 로그인 API
     */
    public void login () {

    }
}
