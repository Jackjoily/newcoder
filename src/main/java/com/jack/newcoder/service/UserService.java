package com.jack.newcoder.service;

import com.jack.newcoder.dao.UserMapper;
import com.jack.newcoder.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jackjoily
 * @date 2020/10/29 9:50
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

}
