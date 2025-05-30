package com.spring.sns.auth.repository;

import com.spring.sns.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {

}
