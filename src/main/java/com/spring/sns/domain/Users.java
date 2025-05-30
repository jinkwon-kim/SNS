package com.spring.sns.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class Users {
    //속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, length = 100)
    private String userEmail;
    @Column(nullable = false, length = 255)
    private String password;
    @Column(nullable = false, length = 50)
    private String username;

    private String content;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
//생성자

//기능
}
