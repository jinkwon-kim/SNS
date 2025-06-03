package com.spring.sns.repository;

import com.spring.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {
    JdbcTemplate jdbc = new JdbcTemplate();
    public Object findById (Long userId) {
        String sql1 = "SELECT * FROM users WHERE user_id=?";
        Object result = jdbc.queryForObject(sql1, Object.class, userId);

        return result;
    }

    public void editUserPw(Long id, String nowPw, String editPw) {

/*
*비밀번호 수정
*/
// 기존 비밀번호 가져오기
        String sql1 = "SELECT  password FROM users WHERE user_id = ?";

        String selectedPw = jdbc.queryForObject(sql1,  String.class, id);

// 만약 기존 비밀번호랑 입력한 비밀번호가 같다면
        if(selectedPw.equals(nowPw) ){
            // 비밀번호 바꾸기
            String sql2 = "UPDATE users SET password=? WHERE user_id=?";

            jdbc.update(sql2, editPw, id);
        }
// 같지 않다면
        else {
            // 일단은 로그 찍기(후처리는 여기에 입력할 것)
            System.out.println("비밀번호 변경 중, 현재 비밀번호를 잘못 입력함.");
        }
    }

    /*
     *회원정보 수정
     */
    public void updateUserProf(Long userId, String email, String name, String content) {
        String sql1 = "UPDATE users SET email=?, name=?, content=? WHERE user_id=?";

        jdbc.update(sql1, email, name, content, userId);
    }

}

