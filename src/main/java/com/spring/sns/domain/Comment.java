package com.spring.sns.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "comments")
public class Comment {
    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id") // FK 설정: comment 테이블에 user_id 라는 컬럼 만들고, 이 컬럼을 user 테이블 id와 연결
    private User user;

    @Column(nullable = false)
    private String commentText;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    // 생성자

    /**
     * 기본생성자(JPA에서 사용)
     */
    public Comment() {
    }

    public Comment(User user, String commentText) {
        this.user = user;
        this.commentText = commentText;
    }

    public Comment(String commentText) {
        this.commentText = commentText;
    }


    // 기능
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

    // 게터
    public Long getCommentId() {
        return commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void updateComment(String commentText) {
        this.commentText = commentText;
    }

}
