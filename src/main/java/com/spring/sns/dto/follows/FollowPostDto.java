package com.spring.sns.dto.follows;
import java.sql.Timestamp;

public class FollowPostDto {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private String userName;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;

    }    // Getters, Setters 생략 가능 - 롬복 써도 OK
}
