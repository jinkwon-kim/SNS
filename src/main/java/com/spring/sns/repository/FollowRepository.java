package com.spring.sns.repository;

import com.spring.sns.domain.Post;
import com.spring.sns.dto.FollowPostDto;
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



    // 팔로우 추가
    public void addFollow(Long userid, Long targetid) {
        String sql = "INSERT INTO follows (user_id, target_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userid, targetid);
    }

    // 중복 검사용 count 조회
    public int countFollow(Long userid, Long targetid) {
        String sql = "SELECT COUNT(*) FROM follows WHERE user_id = ? AND target_id = ?"; // follows 테이블에서 유저id와 타겟 id로 이루어진 행이 몇개인지 반환
        return jdbcTemplate.queryForObject(sql, Integer.class, userid, targetid); //몇개의 행인지를 integer.class -> int 타입의 값으로 받겠다
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

    //친구 게시물 조회
    public List<FollowPostDto> getFollowPosts(List<Long> friendIds) {

        String inSql = String.join(",", friendIds.stream().map(id -> "?").toList());
        String sql = "SELECT post_id, user_id, title, content, user_name, created_at, updated_at " +
                "FROM posts WHERE user_id IN (" + inSql + ") ORDER BY created_at DESC";

        return jdbcTemplate.query(sql, friendIds.toArray(), (rs, rowNum) -> {
            FollowPostDto dto = new FollowPostDto();
            dto.setPostId(rs.getLong("post_id"));
            dto.setUserId(rs.getLong("user_id"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setUserName(rs.getString("user_name"));
            dto.setCreatedAt(rs.getTimestamp("created_at"));
            dto.setUpdatedAt(rs.getTimestamp("updated_at"));
            return dto;
        });
    }
}
