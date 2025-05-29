package com.spring.sns.post.controller;

import com.spring.sns.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> createdPostAPI() {
        ResponseEntity<String> response = new ResponseEntity<>("success" , HttpStatus.CREATED);
        return response;
    }

}
