package com.spring.sns.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comments {
    @Id
    private Long commentId;
}
