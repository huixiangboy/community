package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-30  20:09
 */
@Mapper
public interface DiscussPostMapper {
   List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
   //@Param用于为参数取别名
    //如果只有一个参数，并且在<if>中使用，则必须加别名
   int selectDiscussPostRows(@Param("userId") int userId);

}
