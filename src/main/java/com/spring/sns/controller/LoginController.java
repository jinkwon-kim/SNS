package com.spring.sns.controller;

import com.spring.sns.domain.User;

import com.spring.sns.dto.loginDto.FollowLogin;

import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.dto.users.UserCreateRequestDto;
import com.spring.sns.dto.users.UserCreateResponseDto;
import com.spring.sns.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@RestController
@RequestMapping("/auth")
public class LoginController {
    //속성
    private final LoginService loginService;
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            "xA7bS8p3Wj6nKdL0gZf2QeX9UvHcRyTmBpNcLrVoYiEjTsMwZqFtGhAkDsPlMzXcN"
                    .getBytes(StandardCharsets.UTF_8));
    private final long EXPIRATION_TIME = 60 * 60 * 1000 * 2; // 유효기간 2시간
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
            // 유효성 검증 + 사용자 조회
            User user = loginService.login(dto);


            //로그인 성공 시
            FollowLogin.LoginState.isLoggedIn = 1;

            // JWT 생성
            String token = Jwts.builder()
                    .setSubject(user.getUserEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                    .compact();

            // 응답 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body("로그인 성공");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("로그인 실패: " + e.getMessage());
        }
    }


    /**
     * 로그아웃 API
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String userEmail) {
        try {

            FollowLogin.LoginState.isLoggedIn = 0;

            loginService.logout(userEmail);
            return ResponseEntity.ok("로그아웃 성공");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("로그아웃 실패: " + e.getMessage());
        }
    }
    /**
     * 회원 탈퇴
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody LoginRequestDto dto) {
        try {
            loginService.deleteUser(dto);
            return ResponseEntity.ok("회원탈퇴 완료");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("회원탈퇴 실패: " + e.getMessage());
        }
    }
    /**
     * 회원가입
     */
    @PostMapping
    public ResponseEntity<UserCreateResponseDto> createUserAPI(@RequestBody UserCreateRequestDto requestDto) {
        UserCreateResponseDto responseDto = loginService.createUserService(requestDto);
        ResponseEntity<UserCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }
}


