package com.spring.sns.service;

import com.spring.sns.domain.Comment;
import com.spring.sns.dto.comments.*;
import com.spring.sns.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
//        User user = new User();
//        user.setUserId(requestDto.getUserId());
//        user.setUserEmail("test@example.com");
//        String commentText = requestDto.getCommentText();

        String commentText = requestDto.getCommentText();

        // 2. 검증로직 작성(필요시)
//        if ~

        // 3. 엔티티 만들기
        Comment comment = new Comment(commentText);

        // 4. 저장
        Comment commentSaved = commentRepository.save(comment);


        // 5. responseDto 만들기
        CommentCreateResponseDto responseDto = new CommentCreateResponseDto(200, "댓글이 작성되었습니다.");


        // 6. responseDto 반환
        return responseDto;
    }

    /**
     * 댓글 조회 기능
     */
    public CommentListResponseDto getCommentService() {

        // 조회
        List<Comment> commentList = commentRepository.findAll();

        // for 문 활용
        List<CommentDto> commentDtoList = new ArrayList<CommentDto>();
        for (Comment comment : commentList) {
            CommentDto commentDto = new CommentDto(comment.getCommentId(), comment.getCommentText(), comment.getCreatedAt());
            commentDtoList.add(commentDto);
        }

        // 반환 dto 만들기
        CommentListResponseDto responseDto = new CommentListResponseDto(commentDtoList);

        // 반환
        return responseDto;
    }

    /**
     * 댓글 수정 기능
     */
    @Transactional
    public CommentUpdateResponseDto updateCommentService(Long commentId, CommentUpdateRequestDto requestDto) {

        // 데이터 준비
        String commentText = requestDto.getCommentText();

        // 검증로직 작성

        // 수정할 대상 조회
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment foundComment = commentOptional.get();

            // 업데이트
            foundComment.updateComment(commentText);

            // responseDto 만들기
            CommentUpdateResponseDto responseDto = new CommentUpdateResponseDto(200, "수정 완료", foundComment.getCommentId());

            // responseDto 반환
            return responseDto;

        } else {
            return null;
        }

    }

    /**
     * 댓글 삭제 기능
     */
    public CommentDeleteResponseDto deleteCommentService(Long commentId) {

        // 데이터 준비
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();

            // 삭제
            commentRepository.delete(comment);

            // responseDto 만들기
            CommentDeleteResponseDto responseDto = new CommentDeleteResponseDto(200, "삭제 완료");

            // responseDto 반환
            return responseDto;
        } else {
            return null;
        }


    }

}


