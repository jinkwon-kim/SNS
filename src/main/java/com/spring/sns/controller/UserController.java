package com.spring.sns.controller;

import com.spring.sns.dto.UserCheckResponseDto;
import com.spring.sns.dto.UserEditPwDto;
import com.spring.sns.dto.UserEditResponseDto;
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

    // 회원수정
    @PatchMapping("/{userId}")
    public ResponseEntity<String> updateUserProf(@RequestParam("userId") Long userId, @PathVariable("email") String email, @PathVariable("name") String name, @PathVariable("content") String content) {
        userService.updateUserProf(userId, email, name, content);
        ResponseEntity<String> response = new ResponseEntity<>("success", HttpStatus.OK);
        return response;
    }
    //비밀번호 수정
    @PatchMapping("/{userId}")
    public ResponseEntity<String> editUserPw(@RequestParam("userId") Long id, @PathVariable("nowPw") String nowPw, @PathVariable("editPw") String editPw) {
        userService.editUserPw(id, nowPw, editPw);
        ResponseEntity<String> response = new ResponseEntity<>("success", HttpStatus.OK);
        return response;
    }
    // 유저 단건 조회
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserProfile1(@PathVariable Long userId) {
        Object result = userService.getProfileService(userId);
        ResponseEntity<Object> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }
}