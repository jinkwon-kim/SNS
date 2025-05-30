package com.spring.sns.service;

import com.spring.sns.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    // 속성
    private final CommentRepository commentRepository;



    // 생성자
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



    // 기능

}
