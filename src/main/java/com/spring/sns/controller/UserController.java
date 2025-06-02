package com.spring.sns.controller;

import com.spring.sns.dto.users.UserCreateRequestDto;
import com.spring.sns.dto.users.UserCreateResponseDto;
import com.spring.sns.dto.users.UserGetProfileResponseDto;
import com.spring.sns.dto.users.UserUpdateRequestDto;
import com.spring.sns.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    //속성
    private UserService userService;

    //생성자
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 기능
    /**
     * 회원가입 API
     */
    @PostMapping
    public ResponseEntity<UserCreateResponseDto> createUserAPI(@RequestBody UserCreateRequestDto requestDto) {
        UserCreateResponseDto responseDto = userService.createUserService(requestDto);
        ResponseEntity<UserCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    /**
     * 회원 조회 API
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserGetProfileResponseDto> getUserProfileAPI(@PathVariable("userId") Long userId) {
        UserGetProfileResponseDto responseDto = userService.getUserProfileService(userId);
        ResponseEntity<UserGetProfileResponseDto> response = new ResponseEntity<>(responseDto ,HttpStatus.OK);
        return response;
    }

    /**
     * 회원 정보 수정 API
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateUserAPI(@PathVariable("userId") Long userid , @RequestBody UserUpdateRequestDto requestDto) {
        ResponseEntity<String> response = new ResponseEntity<>("success" , HttpStatus.OK);
        return response;
    }

}
