package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author dell
* @description 针对表【comments】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Comments
*/
public interface CommentsMapper extends BaseMapper<Comments> {
    @Insert("INSERT INTO comments(video_id, user_id, text, status, created_at) VALUES(#{videoId}, #{userId}, #{text}, #{status}, #{createdAt})")
    void insertComment(Comments comment);

    @Delete("DELETE FROM comments WHERE comment_id = #{commentId}")
    void deleteComment(int commentId);

    @Select("SELECT * FROM comments WHERE video_id = #{videoId} AND status = 'visible'")
    List<Comments> selectCommentsByVideoId(int videoId);

}




