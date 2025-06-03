package com.spring.sns.dto.comments;

import java.util.List;

public class CommentListResponseDto {

    // 속성
    private List<CommentDto> commentDtoList;

    // 생성자
    public CommentListResponseDto(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
    }

    // 기능
    public List<CommentDto> getCommentDtoList() {
        return commentDtoList;
    }
}
