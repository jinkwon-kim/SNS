package com.spring.sns.service;

import com.spring.sns.domain.Post;
import com.spring.sns.dto.posts.PostCreateRequestDto;
import com.spring.sns.dto.posts.PostCreateResponseDto;
import com.spring.sns.dto.posts.PostListDto;
import com.spring.sns.dto.posts.PostListResponseDto;
import com.spring.sns.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    // 속성
    private PostRepository postRepository;

    // 생성자
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 기능
    /**
     * 게시물 생성 기능
     */
    public PostCreateResponseDto createPostService(PostCreateRequestDto requestDto) {
        Post foundPost = new Post(requestDto);
        Post savePost = postRepository.save(foundPost);
        PostCreateResponseDto responseDto = new PostCreateResponseDto(savePost);
        return responseDto;
    }

    /**
     * 게시물 전체 조회
     */
    public PostListResponseDto getPostListService() {
        List<Post> postList = postRepository.findAll();
        List<PostListDto> postListDtoList = postList.stream().map(PostListDto::new).collect(Collectors.toList());
        PostListResponseDto responseDto = new PostListResponseDto(postListDtoList);
        return responseDto;
    }
}
