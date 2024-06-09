package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * * VideosMapper 接口，定义了视频相关的数据库操作方法
 *  包括插入视频、更新视频、删除视频、根据视频ID查询视频、根据用户ID查询视频列表、查询所有视频等方法
 * 这些方法将被MyBatis-Plus框架自动识别并调用。
* @author ff
* @description 针对表【videos】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Videos
*/
@Mapper
public interface VideosMapper extends BaseMapper<Videos> {
    @Select("SELECT * FROM videos WHERE title LIKE CONCAT('%', #{title}, '%')")
    IPage<Videos> selectPagedVideos(Page<?> page, @Param("title") String title);
}




