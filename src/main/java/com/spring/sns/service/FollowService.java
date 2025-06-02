package com.spring.sns.service;

import com.spring.sns.domain.Post;
import com.spring.sns.repository.FollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    private final FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    // 팔로우 추가
    public void followTarget(Long userid, Long targetid) {
        int count = followRepository.countFollow(userid, targetid);
        if (count > 0) {
            throw new IllegalStateException("이미 팔로우 중입니다.");
        }
        followRepository.addFollow(userid, targetid);
    }

    // 팔로우 삭제
    public void unfollowTarget(Long userid, Long targetid) {
        int rowsAffected = followRepository.removeFollow(userid, targetid);
        if (rowsAffected == 0) {
            throw new IllegalStateException("삭제할 팔로우가 존재하지 않습니다.");
        }
    }

    // 팔로우 목록 조회
    public List<Long> getFollowList(Long userid) {
        return followRepository.getFollowList(userid);
    }

    //친구 게시물 조회
    /*
    public List<Post> getFriendPost(Long userid){

        List<Long> followids = followRepository.getFollowList(userid);
        return followRepository.getFollowPost(followids);
    }
*/

}
