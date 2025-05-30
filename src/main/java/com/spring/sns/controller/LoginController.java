package com.spring.sns.controller;

import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginRequestDto requestDto){
        ResponseEntity<String> response = new ResponseEntity<>("create", HttpStatus.CREATED);
        return response;
    }

}
