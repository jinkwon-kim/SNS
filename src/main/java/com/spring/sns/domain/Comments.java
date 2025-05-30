package com.spring.sns.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comments {

    // 속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String commentText;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    // 생성자
    /**
     * 기본생성자(JPA에서 사용)
     */
    public Comments() {}

    /**
     * createCommentRequestDto에서 사용하는 생성자
     * @param userName
     * @param commentText
     */
    public Comments(String userName, String commentText) {
        this.userName = userName;
        this.commentText = commentText;
    }

    // 기능

}
