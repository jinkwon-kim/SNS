package com.spring.sns.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class Follows {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USER_ID", nullable = false)
    private Long userId;
    @Column(name = "TARGET_ID", nullable = false)
    private Long targetId;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    /**
     * 엔티티가 처음 저장되기 직전에 호출
     * createdAt 필드를 현재 UTC 시간으로 초기화
     */
    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        this.createdAt = now;
    }
}
