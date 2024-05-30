package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Likes;
import cn.edu.ujn.shortvideo.entities.dox.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
* @author dell
* @description 针对表【likes】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Likes
*/
public interface LikesMapper extends BaseMapper<Likes> {

    Optional<Likes> findByVideoIdAndUserId(@Param("videoId") Integer videoId, @Param("userId") Integer userId);
    Likes save(Likes like);

    boolean existsById(Integer likeId);

}




