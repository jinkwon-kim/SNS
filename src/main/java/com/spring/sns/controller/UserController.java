package com.spring.sns.controller;

import com.spring.sns.dto.users.UserCheckResponseDto;
import com.spring.sns.dto.users.UserEditRequestDto;
import com.spring.sns.dto.users.UserEditResponseDto;
import com.spring.sns.service.UserService;
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
    @GetMapping("/{userId}")
    public ResponseEntity<UserEditResponseDto> getUserAPI(@PathVariable("userId") Long userId) {
        UserEditResponseDto responseDto = userService.getUserService(userId);
        ResponseEntity<UserEditResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserEditResponseDto> updateUserAPI(@PathVariable("userId") Long userId , @RequestBody UserEditRequestDto requestDto) {
        UserEditResponseDto responseDto = userService.updateUserService(userId, requestDto);
        ResponseEntity<UserEditResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }


}