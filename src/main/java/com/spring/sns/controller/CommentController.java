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
    public ResponseEntity<?> createCommentAPI(@RequestBody CommentCreateRequestDto requestDto) {
        try {
            CommentCreateResponseDto responseDto = commentService.createCommentService(requestDto);
            ResponseEntity<CommentCreateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException illegalArgumentException) {
            ResponseEntity<String> response = new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }
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
    public ResponseEntity<?> updateCommentAPI(
            @PathVariable("commentId") Long commentId,
            @RequestBody CommentUpdateRequestDto requestDto
    ) {
        try {
            CommentUpdateResponseDto responseDto = commentService.updateCommentService(commentId, requestDto);
            ResponseEntity<CommentUpdateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException illegalArgumentException) {
            ResponseEntity<String> response = new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    /**
     * 댓글 삭제 API
     */
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteCommentAPI(@PathVariable("commentId") Long commentId) {
        try {
            CommentDeleteResponseDto responseDto = commentService.deleteCommentService(commentId);
            ResponseEntity<CommentDeleteResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException illegalArgumentException) {
            ResponseEntity<String> response = new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }

    }


}
