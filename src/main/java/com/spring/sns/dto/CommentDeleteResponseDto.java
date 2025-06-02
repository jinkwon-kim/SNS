package com.spring.sns.dto;

public class CommentDeleteResponseDto {

    private int status;
    private String message;

    public CommentDeleteResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
