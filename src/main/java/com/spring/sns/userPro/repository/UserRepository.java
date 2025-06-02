package com.spring.sns.userPro.repository;

import com.spring.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
