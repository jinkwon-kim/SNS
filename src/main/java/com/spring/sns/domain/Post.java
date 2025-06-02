package com.spring.sns.domain;

import com.spring.sns.dto.posts.PostCreateRequestDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "posts")
public class Post {
    // 속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;


    /**
     * 엔티티가 처음 저장되기 직전에 호출
     * createdAt , updatedAt 필드를 현재 UTC 시간으로 초기화
     */
    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        this.createdAt = now;
        this.updatedAt = now;
    }

    /**
     * 엔티티가 수정되기 직전에 호출
     * updatedAt 필드를 현재 UTC 시간으로 초기화
     */
    @PreUpdate
    public void onUpdate() {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        this.updatedAt = now;
    }

    // 생성자
    /**
     * 기본생성자(JPA에서 사용)
     */
    public Post() {}

    public Post(PostCreateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.userName = requestDto.getUserName();
    }

    // 기능
    // 게터


    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
