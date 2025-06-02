package com.spring.sns.service;

import com.spring.sns.domain.User;
import com.spring.sns.dto.users.UserCreateRequestDto;
import com.spring.sns.dto.users.UserCreateResponseDto;
import com.spring.sns.dto.users.UserGetProfileResponseDto;
import com.spring.sns.dto.users.UserUpdateRequestDto;
import com.spring.sns.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    // 속성
    private UserRepository userRepository;

    // 생성자
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 기능

    /**
     * 회원가입 기능
     */
    public UserCreateResponseDto createUserService(UserCreateRequestDto requestDto) {
        User user = new User(requestDto);
        User saveUser = userRepository.save(user);
        UserCreateResponseDto responseDto = new UserCreateResponseDto(saveUser);
        return responseDto;
    }

    /**
     * 회원 조회 기능
     */
    public UserGetProfileResponseDto getUserProfileService(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            UserGetProfileResponseDto responseDto = new UserGetProfileResponseDto(foundUser);
            return responseDto;
        } else {
            return null;
        }
    }

    /**
     * 회원 정보 수정 기능
     */
    public void updateUserService(Long userId , UserUpdateRequestDto requestDto) {

    }
}
