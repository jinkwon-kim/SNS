package com.spring.sns.service;

import com.spring.sns.domain.User;
import com.spring.sns.dto.UserEditRequestDto;
import com.spring.sns.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.spring.sns.dto.UserCheckResponseDto;


import java.util.Optional;

@Service
public class UserService {
    // 속성
    private final UserRepository userRepository;

    // 생성자
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 기능

    /**
     * 게시물 단건 조회 API
     */
    public UserCheckResponseDto getProfileService(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();

            // dto 만들기
            UserCheckResponseDto userCheckResponseDto = new UserCheckResponseDto(foundUser);
            return userCheckResponseDto;
        } else {
            return null;
        }
    }
    //회원 수정
    public void EditUserService(Long userId , UserEditRequestDto requestDto) {

    }
}