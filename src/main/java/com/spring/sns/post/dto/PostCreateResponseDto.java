package com.spring.sns.post.dto;

import com.spring.sns.post.domain.Post;

import java.time.LocalDateTime;

public class PostCreateResponseDto {
    // 속성
    private Long id;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime cratedAt;
    private LocalDateTime updatedAt;

    // 생성자
    public PostCreateResponseDto(Post post) {
        this.id = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userName = post.getUserName();
        this.cratedAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }

    // 기능
    // 게터
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
