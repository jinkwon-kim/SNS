package com.spring.sns.repository;

import com.spring.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Long> {
    //기능
    //이메일 기준으로 사용자 조회
    Optional<User> findByUserEmail(String userEmail);

}
