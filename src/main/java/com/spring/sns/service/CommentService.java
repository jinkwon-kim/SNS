package com.spring.sns.service;

import com.spring.sns.domain.Comment;
import com.spring.sns.domain.User;
import com.spring.sns.dto.CommentCreateRequestDto;
import com.spring.sns.dto.CommentCreateResponseDto;
import com.spring.sns.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class CommentService {

    // 속성
    private final CommentRepository commentRepository;



    // 생성자
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



    // 기능
    /**
     * 댓글 생성 기능
     */
    public CommentCreateResponseDto createCommentService(CommentCreateRequestDto requestDto) {

        // 1. 데이터 준비
        // 테스트 용 //
        User user = new User();
        user.setUserId(requestDto.getUserId());
        user.setUserEmail("test@example.com");
        String commentText = requestDto.getCommentText();

        // 2. 검증로직 작성(필요시)
//        if ~

        // 3. 엔티티 만들기
        Comment comment = new Comment(user, commentText);

        // 4. 저장
        Comment commentSaved = commentRepository.save(comment);


        // 5. responseDto 만들기
        CommentCreateResponseDto responseDto = new CommentCreateResponseDto(200, "댓글이 작성되었습니다.");


        // 6. responseDto 반환
        return responseDto;
    }

    }

