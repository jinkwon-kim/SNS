package com.spring.sns.dto.posts;

import java.util.List;

public class PostListResponseDto {
    private List<PostListDto> postListDto;

    public PostListResponseDto(List<PostListDto> postListDto) {
        this.postListDto = postListDto;
    }

    public List<PostListDto> getPostListDto() {
        return postListDto;
    }
}
