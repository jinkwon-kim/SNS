package com.spring.sns.post.service;

import com.spring.sns.post.domain.Post;
import com.spring.sns.post.dto.PostCreateRequestDto;
import com.spring.sns.post.dto.PostCreateResponseDto;
import com.spring.sns.post.dto.PostListDto;
import com.spring.sns.post.dto.PostListResponseDto;
import com.spring.sns.post.repository.PostRepository;
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
     * 게시물 생성 API
     */
    public PostCreateResponseDto createPostService(PostCreateRequestDto requestDto) {
        // 데이터 준비
        String title = requestDto.getTitle();
        String content = requestDto.getContent();
        String userName = requestDto.getUserName();

        // 검증 로직

        // 엔티티 만들기
        Post fromPostCreateRequestDto = Post.createFromPostCreateRequestDto(title, content, userName);

        // 저장
        Post savePost = postRepository.save(fromPostCreateRequestDto);

        // responseDto 만들기
        PostCreateResponseDto responseDto = new PostCreateResponseDto(savePost);
        return responseDto;
    }

    /**
     * 게시물 전체 조회 API
     */
    public PostListResponseDto getPostListService() {
        // 데이터 조회
        List<Post> postList = postRepository.findAll();
        // Stream 사용
        List<PostListDto> postListDtoList = postList.stream().map(post -> new PostListDto(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                post.getUserName(),
                post.getCreatedAt(),
                post.getUpdatedAt())
        ).collect(Collectors.toList());

        // 반환 Dto 만들기
        PostListResponseDto postListResponseDto = new PostListResponseDto(postListDtoList);

        // 반환
        return postListResponseDto;
    }
}
