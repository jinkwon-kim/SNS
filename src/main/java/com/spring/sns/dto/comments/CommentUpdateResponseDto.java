package com.spring.sns.dto.comments;

public class CommentUpdateResponseDto {

    // 속성
    private int status;
    private String message;
    private Long commentId;

    // 생성자
    public CommentUpdateResponseDto(int status, String message, Long commentId) {
        this.status = status;
        this.message = message;
        this.commentId = commentId;
    }

    // 기능
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getCommentId() {
        return commentId;
    }
}
