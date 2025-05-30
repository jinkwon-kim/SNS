package com.spring.sns.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Posts {
    @Id
    private Long postId;
}
