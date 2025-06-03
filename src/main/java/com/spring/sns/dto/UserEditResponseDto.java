package com.spring.sns.dto;

import com.spring.sns.domain.User;

import java.time.LocalDateTime;

public class UserEditResponseDto {
    // 속성
    private Long id;
    private String userEmail;
    private String userName;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자
    public UserEditResponseDto(User user) {
        this.id = getId();
        this.userEmail = getUserEmail();
        this.content = getContent();
        this.userName = getUserName();
        this.createdAt = getCreatedAt();
        this.updatedAt = getUpdatedAt();
    }

    // 기능
    // 게터
    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
