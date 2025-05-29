package com.spring.sns.post.dto;

import java.time.LocalDateTime;

public class PostListDto {
    private Long postId;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostListDto(Long postId, String title, String content, String userName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getPostId() {
        return postId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
