package com.spring.sns.dto.loginDto;

public class UserCreateRequestDto {
    // 속성
    private String userEmail;
    private String password;
    private String username;
    private String content;

    // 생성자
    public UserCreateRequestDto() {}

    // 기능
    // 게터
    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
}
