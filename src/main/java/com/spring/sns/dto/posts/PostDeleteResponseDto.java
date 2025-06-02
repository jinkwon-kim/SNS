package com.spring.sns.dto.posts;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PostDeleteResponseDto {
    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public PostDeleteResponseDto(int status) {
        this.status = status;
    }

    public PostDeleteResponseDto(int status, String message) {
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
