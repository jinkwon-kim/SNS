package com.spring.sns.dto.comments;

public class CommentCreateRequestDto {

    // 속성
    private String userName;
    private String commentText;

    /**
     * 테스트용
     */
    //private Long userId;

    // 생성자
    public CommentCreateRequestDto(String userName, String commentText) {
        this.userName = userName;
        this.commentText = commentText;
    }


    // 기능

    public String getUserName() {
        return userName;
    }

    public String getCommentText() {
        return commentText;
    }



}
