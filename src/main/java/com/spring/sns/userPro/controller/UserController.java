package com.spring.sns.userPro.controller;

import com.spring.sns.userPro.dto.UserCheckResponseDto;
import com.spring.sns.userPro.dto.UserEditResponseDto;
import com.spring.sns.userPro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    // 속성
    private final UserService userService;

    // 생성자
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 기능

    // 회원수정
    @PatchMapping
    public ResponseEntity<String> updateUserAPI(@PathVariable("userId") Long userId, @RequestBody UserEditResponseDto requestDto) {
        ResponseEntity<String> response = new ResponseEntity<>("success", HttpStatus.OK);
        return response;
    }
    // 유저 단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserCheckResponseDto> getUserService(@PathVariable("userId") Long userId) {
        UserCheckResponseDto UserService = userService.getProfileService(userId);
        ResponseEntity<UserCheckResponseDto> response = new ResponseEntity<>(UserService, HttpStatus.OK);
        return response;
    }



}