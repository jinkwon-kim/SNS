package com.spring.sns.post.controller;

import com.spring.sns.post.dto.PostCreateRequestDto;
import com.spring.sns.post.dto.PostCreateResponseDto;
import com.spring.sns.post.dto.PostListResponseDto;
import com.spring.sns.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    // 속성
    private PostService postService;

    // 생성자
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 기능

    /**
     * 게시물 생성 API
     */
    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createdPostAPI(@RequestBody PostCreateRequestDto requestDto) {
        PostCreateResponseDto responseDto = postService.createPostService(requestDto);
        ResponseEntity<PostCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    /**
     * 게시물 전체 조회 API
     */
    @GetMapping
    public ResponseEntity<PostListResponseDto> getPostListAPI() {
        PostListResponseDto postListService = postService.getPostListService();
        ResponseEntity<PostListResponseDto> response = new ResponseEntity<>(postListService , HttpStatus.OK);
        return response;
    }

}
