package com.spring.sns.post.service;

import com.spring.sns.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // 속성
    private PostRepository postRepository;

    // 생성자
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 기능


}
