package com.spring.sns.controller;

import com.spring.sns.dto.posts.*;
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
    public ResponseEntity<PostDetailResponseDto> getPostDetailAPI(@PathVariable("postId") Long postId) {
        PostDetailResponseDto responseDto = postService.getPostDetailService(postId);
        ResponseEntity<PostDetailResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    /**
     * 게시물 수정 API
     */
    @PatchMapping("/{postId}")
    public ResponseEntity<PostUpdateResponseDto> updatePostAPI(@PathVariable("postId") Long postId , @RequestBody PostUpdateRequestDto requestDto) {
        PostUpdateResponseDto responseDto = postService.updatePostService(postId, requestDto);
        ResponseEntity<PostUpdateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    /**
     * 게시물 삭제 API
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostAPI(@PathVariable("postId") Long postId) {
        postService.deletePostService(postId);
        ResponseEntity<String> response = new ResponseEntity<>("deleted" , HttpStatus.OK);
        return response;
    }
}
