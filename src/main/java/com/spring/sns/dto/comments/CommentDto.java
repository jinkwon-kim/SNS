package com.spring.sns.dto.comments;

import java.time.LocalDateTime;

public class CommentDto {
    // 속성
    private Long commentId;
    private String commentText;
    private LocalDateTime createdAt;

    // 생성자
    public CommentDto(Long commentId, String commentText, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.createdAt = createdAt;
    }

    // 기능
    public Long getCommentId() {
        return commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
