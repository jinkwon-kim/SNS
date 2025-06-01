package com.spring.sns.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FollowRepository {

    private final JdbcTemplate jdbcTemplate;

    // 생성자 주입
    public FollowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 중복 검사용 count 조회
    public int countFollow(Long userid, Long targetid) {
        String sql = "SELECT COUNT(*) FROM follows WHERE user_id = ? AND target_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, userid, targetid);
    }

    // 팔로우 추가
    public void addFollow(Long userid, Long targetid) {
        String sql = "INSERT INTO follows (user_id, target_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userid, targetid);
    }

    // 팔로우 삭제
    public int removeFollow(Long userid, Long targetid) {
        String sql = "DELETE FROM follows WHERE user_id = ? AND target_id = ?";
        return jdbcTemplate.update(sql, userid, targetid);
    }

    // 팔로우 목록 조회
    public List<Long> getFollowList(Long userid) {
        String sql = "SELECT target_id FROM follows WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong("target_id"), userid);
    }
}
