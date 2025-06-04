package com.spring.sns.service;

import com.spring.sns.config.PasswordEncoder;
import com.spring.sns.domain.User;
import com.spring.sns.dto.users.UserEditRequestDto;
import com.spring.sns.dto.users.UserEditResponseDto;
import com.spring.sns.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.spring.sns.dto.users.UserCheckResponseDto;


import java.util.Optional;

@Service
public class UserService {
    // 속성
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 생성자
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 기능
    /**
     * 유저 조회 기능
     */
    public UserEditResponseDto getUserService(Long userID) {
        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User founduser = optionalUser.get();
            UserEditResponseDto responseDto = new UserEditResponseDto(founduser);
            return responseDto;
        } else {
            return null;
        }
    }

    /**
     * 유저 정보 업데이트 기능
     */
    @Transactional
    public UserEditResponseDto updateUserService(Long userId, UserEditRequestDto requestDto){
        String password = requestDto.getPassword();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User founduser = optionalUser.get();
            if (founduser.getUserEmail().equals(requestDto.getUserEmail()) && passwordEncoder.matches(password, founduser.getPassword())) {
                founduser.updateUser(requestDto);

                UserEditResponseDto responseDto = new UserEditResponseDto(founduser);
                return responseDto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}