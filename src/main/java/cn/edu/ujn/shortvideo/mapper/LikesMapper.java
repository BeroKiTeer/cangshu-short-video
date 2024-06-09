package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Likes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author dell
* @description 针对表【likes】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Likes
*/
public interface LikesMapper extends BaseMapper<Likes> {


    @Select("SELECT * FROM likes WHERE video_id = #{videoId} AND user_id = #{userId}")
    Likes findByVideoIdAndUserId(@Param("videoId") Integer videoId, @Param("userId") Integer userId);

    @Insert("INSERT INTO likes (video_id, user_id, created_at) VALUES (#{like.videoId}, #{like.userId}, #{like.createdAt})")
    int save(@Param("like") Likes like);

    @Select("SELECT COUNT(*) > 0 FROM likes WHERE id = #{likeId}")
    boolean existsById(@Param("likeId") Integer likeId);

    @Delete("DELETE FROM likes WHERE id = #{likeId}")
    int deleteById(@Param("likeId") Integer likeId);
}




