package com.spring.sns.service;

import com.spring.sns.domain.User;
import com.spring.sns.dto.UserEditPwDto;
import com.spring.sns.dto.UserEditRequestDto;
import com.spring.sns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.sns.dto.UserCheckResponseDto;


import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepo = new UserRepository();
    // 속성

    // 생성자

    // 기능

    /**
     * 유저 단건 조회 API
     */
    public Object getProfileService(Long userId) {
        Object result = userRepo.findById(userId);
        return result;
    }
    //유저 패스워드 수정
    public void editUserPw(Long id, String nowPw, String editPw) {
        userRepo.editUserPw(id, nowPw, editPw);
    }

    //회원 수정
    public void updateUserProf (Long userId, String email, String name, String content) {
        userRepo.updateUserProf(userId, email, name, content);
    }
}