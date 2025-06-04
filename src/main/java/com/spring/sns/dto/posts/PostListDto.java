package com.spring.sns.dto.posts;

import com.spring.sns.domain.Post;

import java.time.LocalDateTime;

public class PostListDto {
    // 속성
    private Long postId;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자
    public PostListDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userName = post.getUserName();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }

    // 기능
    // 게터
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
