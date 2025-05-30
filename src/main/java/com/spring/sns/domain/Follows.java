package com.spring.sns.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Follows {
    @Id
    private Long id;

    private Long userId;
    private Long targetId;
    private LocalDateTime createdAt;
}
