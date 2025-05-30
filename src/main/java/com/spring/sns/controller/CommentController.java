package com.spring.sns.controller;

import com.spring.sns.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    // 속성
    private final CommentService commentService;



    // 생성자
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    // 기능

}
