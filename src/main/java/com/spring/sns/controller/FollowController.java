package com.spring.sns.controller;

import com.spring.sns.dto.follows.FollowPostDto;
import com.spring.sns.dto.loginDto.FollowLogin;

import com.spring.sns.repository.FollowRepository;
import com.spring.sns.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/follows")

public class FollowController {
    /*
    1.친구 팔로우 (post)
    2.친구 언팔로우 (delete)
    3.친구 목록 조회 (get)
     */
    //INSERT INTO users (user_email, password, user_name, content) VALUES ('test@example.com', 'password123', 'testuser', '테스트 유저'); 유저 주입
    //SELECT user_id, user_email, user_name FROM users WHERE user_email = 'test@example.com'; email 입력시 유저 id확인 가능
    private final FollowService followService;
    private final FollowRepository followRepository;

    //의존성 주입
    public FollowController(FollowService followService, FollowRepository followRepository) {
        this.followService = followService;
        this.followRepository = followRepository;
    }

    //1.친구 팔로우
    @PostMapping("/{userid}/follow/{targetid}")
    public ResponseEntity<String> followtarget(@PathVariable Long userid, @PathVariable Long targetid) {

        if (FollowLogin.LoginState.isLoggedIn != 1) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        followService.followTarget(userid, targetid);
        return ResponseEntity.ok("팔로우가 정상적으로 처리되었습니다");
    }

    //친구 언팔
    @DeleteMapping("/{userid}/follow/{targetid}")
    public ResponseEntity<String> unfollowtarget(@PathVariable Long userid, @PathVariable Long targetid) {

        if (FollowLogin.LoginState.isLoggedIn != 1) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }
        followService.unfollowTarget(userid, targetid);
        return ResponseEntity.ok("언팔로우가 정상적으로 처리되었습니다");
    }

    //친구 목록조회
    @GetMapping("/{userid}/follow")
    public ResponseEntity<?> getFollowList(@PathVariable Long userid) {
        if (FollowLogin.LoginState.isLoggedIn != 1) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        List<Long> followList = followService.getFollowList(userid);
        return ResponseEntity.ok(followList);
    }

    //팔로잉한 사람의 게시물 즈회
    @GetMapping("/{targetid}/follow/feed")

    public ResponseEntity<?> getFollowFeed(@PathVariable Long targetid) {
        if (FollowLogin.LoginState.isLoggedIn != 1) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        List<FollowPostDto> feed = followService.getFollowFeed(targetid);
        return ResponseEntity.ok(feed);
    }

}

