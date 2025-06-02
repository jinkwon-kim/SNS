package com.spring.sns.controller;

import com.spring.sns.dto.posts.PostCreateRequestDto;
import com.spring.sns.dto.posts.PostCreateResponseDto;
import com.spring.sns.dto.posts.PostListResponseDto;
import com.spring.sns.service.PostService;
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
     * 게시물 CREATE API
     */
    @PostMapping
    public ResponseEntity<PostCreateResponseDto> createPostAPI(@RequestBody PostCreateRequestDto requestDto) {
        PostCreateResponseDto responseDto = postService.createPostService(requestDto);
        ResponseEntity<PostCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    /**
     * 게시물 전체 조회 API
     */
    @GetMapping
    public ResponseEntity<PostListResponseDto> getPostListAPI() {
        PostListResponseDto responseDto = postService.getPostListService();
        ResponseEntity<PostListResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    /**
     * 게시물 단건 조회 API
     */
    @GetMapping("/{postId}")
    public ResponseEntity<String> getPostDetailAPI(@PathVariable("postId") Long postId) {
        ResponseEntity<String> response = new ResponseEntity<>("success" , HttpStatus.OK);
        return response;
    }
}
