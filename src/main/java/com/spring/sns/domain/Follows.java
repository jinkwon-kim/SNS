package com.spring.sns.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Follows {
    @Id
    private Long id;
}
