package com.spring.sns.dto;

public class CommentCreateResponseDto {

    private int status;
    private String message;

    public CommentCreateResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
