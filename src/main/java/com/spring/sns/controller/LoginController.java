package com.spring.sns.controller;

import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    //속성
    private final LoginService loginService;

    //생성자
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    //기능

    /**
     * 로그인 API
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
        try {
            String result = loginService.login(dto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("로그인 실패: " + e.getMessage());
        }
    }

    /**
     * 로그아웃 API
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String userEmail) {
        try {
            loginService.logout(userEmail);
            return ResponseEntity.ok("로그아웃 성공");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("로그아웃 실패: " + e.getMessage());
        }
    }
}


