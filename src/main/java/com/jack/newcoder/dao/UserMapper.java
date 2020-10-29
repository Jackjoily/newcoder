package com.jack.newcoder.dao;

import com.jack.newcoder.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jackjoily
 * @date 2020/10/28 15:55
 */
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByUserName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, int password);
}
