package com.jack.newcoder.dao;

import com.jack.newcoder.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jackjoily
 * @date 2020/10/29 9:13
 */
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);

    //@Param注解用于给参数取别名
    //如果只有一个参数，并且在《if》里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
