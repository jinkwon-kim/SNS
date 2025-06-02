package com.spring.sns.dto;

import java.time.LocalDateTime;

public class CommentDto {

    /**
     *
     */
    private Long commentId;
    private String commentText;
    private LocalDateTime createdAt;

    public CommentDto(Long commentId, String commentText, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.createdAt = createdAt;
    }

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
