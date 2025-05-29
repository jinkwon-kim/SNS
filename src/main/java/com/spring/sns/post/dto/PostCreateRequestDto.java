package com.spring.sns.post.dto;

public class PostCreateRequestDto {
    // 속성
    private String title;
    private String content;
    private String userName;

    // 생성자

    // 기능
    // 게터
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }
}
