package com.jack.newcoder;

import com.jack.newcoder.dao.DiscussPostMapper;
import com.jack.newcoder.dao.UserMapper;
import com.jack.newcoder.entity.DiscussPost;
import com.jack.newcoder.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author jackjoily
 * @date 2020/10/29 8:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NewcoderApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper postMapper;
    @Test
    public void testSelectUser() {
        User user = userMapper.selectByUserName("liubei");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/101.png");
        user.setCreateTime(new Date());
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void updateUser() {
        int i = userMapper.updatePassword(150, 987654321);
        int j = userMapper.updateStatus(150, 1);
        int k = userMapper.updateHeader(150, "xxxxxxxxxxxx");
    }


    @Test
    public void testSelectPost() {
        List<DiscussPost> discussPosts = postMapper.selectDiscussPost(149, 0, 10);
        discussPosts.forEach(System.out::println);
    }
    @Test
    public void testselectDiscussPostRows() {
        int i = postMapper.selectDiscussPostRows(0);
        System.out.println(i);
    }
}
