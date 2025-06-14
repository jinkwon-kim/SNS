package com.spring.sns.service;

import com.spring.sns.config.PasswordEncoder;
import com.spring.sns.dto.loginDto.LoginRequestDto;
import com.spring.sns.domain.User;
import com.spring.sns.dto.users.UserCreateRequestDto;
import com.spring.sns.dto.users.UserCreateResponseDto;
import com.spring.sns.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
    //속성
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    //생성자
    public LoginService (LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //기능
    /**
     * 회원 가입 기능
     */
    @Transactional
    public UserCreateResponseDto createUserService(UserCreateRequestDto requestDto) {
        //매일 중복 확인
        if (loginRepository.existsByUserEmail(requestDto.getUserEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // User 객체 생성 시 암호화된 비밀번호로 세팅
        User user = new User(
                requestDto.getUserEmail(),
                encodedPassword,
                requestDto.getUserName(),
                requestDto.getContent()
        );
        User saveUser = loginRepository.save(user);
        return new UserCreateResponseDto(saveUser);
    }

    /**
     * 로그인 기능
     */
    @Transactional
    public User login (LoginRequestDto requestDto) {
        //데이터 준비
        String userEmail = requestDto.getUserEmail();
        String password = requestDto.getPassword();
        //이메일로 사용자 찾기
        User user = loginRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));
        //비밀번호 비교
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        //로그인 성공
        return user;
    }

    /**
     * 로그아웃 기능
     */
    @Transactional
    public void logout(String userEmail) {
        User user = loginRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        System.out.println("로그아웃 처리 완료: " + userEmail);
    }

    /**
     * 회원 탈퇴 기능
     */
    @Transactional
    public void deleteUser(LoginRequestDto dto) {
        String userEmail = dto.getUserEmail();
        String password = dto.getPassword();

        User user = loginRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호 불일치로 탈퇴 실패");
        }

        loginRepository.delete(user);
    }
}

