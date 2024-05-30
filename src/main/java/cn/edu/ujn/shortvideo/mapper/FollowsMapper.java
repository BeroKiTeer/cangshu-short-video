package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Follows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
* @author dell
* @description 针对表【follows】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Follows
*/
public interface FollowsMapper extends BaseMapper<Follows> {
    @Insert("INSERT INTO follows (follower_id, followed_id, created_at) VALUES (#{followerId}, #{followedId}, NOW())")
    void insertFollow(@Param("followerId") int followerId, @Param("followedId") int followedId);

    @Delete("DELETE FROM follows WHERE follow_id = #{followId}")
    void deleteFollow(@Param("followId") int followId);

}




