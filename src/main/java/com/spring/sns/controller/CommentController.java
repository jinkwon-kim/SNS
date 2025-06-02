package com.spring.sns.controller;

import com.spring.sns.dto.comments.*;
import com.spring.sns.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 댓글 생성 API
     */
    @PostMapping
    public ResponseEntity<CommentCreateResponseDto> createCommentAPI(@RequestBody CommentCreateRequestDto requestDto) {
//        String userName = requestDto.getUserName();
//        String commentText = requestDto.getCommentText();
//        System.out.println("userName = " + userName);
//        System.out.println("commentText = " + commentText); -> 테스트

        CommentCreateResponseDto responseDto = commentService.createCommentService(requestDto);
        ResponseEntity<CommentCreateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    /**
     * 댓글 조회 API
     */
    @GetMapping
    public ResponseEntity<CommentListResponseDto> getCommentAPI() {
        CommentListResponseDto responseDto = commentService.getCommentService();
        ResponseEntity<CommentListResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    /**
     * 댓글 수정 API
     */
    @PatchMapping("/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateCommentAPI(
            @PathVariable("commentId") Long commentId,
            @RequestBody CommentUpdateRequestDto requestDto
    ) {
        CommentUpdateResponseDto responseDto = commentService.updateCommentService(commentId, requestDto);
        ResponseEntity<CommentUpdateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    /**
     * 댓글 삭제 API
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDeleteResponseDto> deleteCommentAPI(@PathVariable("commentId") Long commentId) {
        CommentDeleteResponseDto responseDto = commentService.deleteCommentService(commentId);
        ResponseEntity<CommentDeleteResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }


}
