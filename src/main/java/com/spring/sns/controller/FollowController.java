package com.spring.sns.controller;

import com.spring.sns.repository.FollowRepository;
import com.spring.sns.service.FollowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FollowController {
    /*
    1.친구 팔로우 (post)
    2.친구 언팔로우 (delete)
    3.친구 목록 조회 (get)
     */
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
        followService.followTarget(userid, targetid);
        return ResponseEntity.ok("팔로우가 정상적으로 처리되었습니다");
    }

    //친구 언팔
    @DeleteMapping("/{userid}/follow/{targetid}")
    public ResponseEntity<String> unfollowtarget(@PathVariable Long userid, @PathVariable Long targetid) {
        followService.unfollowTarget(userid, targetid);
        return ResponseEntity.ok("언팔로우가 정상적으로 처리되었습니다");
    }

    //친구 목록조회
    @GetMapping("/{userid}/follow")
    public ResponseEntity<List<Long>> getFollowList(@PathVariable Long userid) {
        List<Long> followList = followService.getFollowList(userid);
        return ResponseEntity.ok(followList);
    }

    //팔로잉한 사람의 게시물 즈회
    /*
    @GetMapping("/{userid}/follow/feed")
    public ResponseEntity<List<Post>> getFollowFeed(@PathVariable Long userid) {
        List<Post> feed = followService.getFriendPost(userid);
        return ResponseEntity.ok(feed);
    }

     */

}

