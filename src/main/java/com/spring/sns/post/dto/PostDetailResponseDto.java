package com.spring.sns.post.dto;

import com.spring.sns.post.domain.Post;

import java.time.LocalDateTime;

public class PostDetailResponseDto {
    private Long postid;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Post post;

    public PostDetailResponseDto(Post post) {
        this.postid = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userName = post.getUserName();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }


}
