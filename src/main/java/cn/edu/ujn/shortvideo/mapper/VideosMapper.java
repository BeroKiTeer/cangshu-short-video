package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * * VideosMapper 接口，定义了视频相关的数据库操作方法
 *  包括插入视频、更新视频、删除视频、根据视频ID查询视频、根据用户ID查询视频列表、查询所有视频等方法
 * 这些方法将被MyBatis-Plus框架自动识别并调用。
 * BaseMapper是MyBatis-Plus提供的一个泛型接口，提供了一些基本的数据库操作方法，如插入、更新、删除等。
* @author ff
* @description 针对表【videos】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Videos
 * @mapper
*/
//这是一个MyBatis的注解，用于标记一个类为MyBatis的映射器接口。
@Mapper
public interface VideosMapper extends BaseMapper<Videos> {
    /**
     * 这是一个MyBatis的查询注解，用于定义一个查询方法的SQL语句。
     * 这里定义的SQL语句是查询videos表中标题包含某个指定字符串的视频记录。
     */
    @Select("SELECT * FROM videos WHERE title LIKE CONCAT('%', #{title}, '%')")
    IPage<Videos> selectPagedVideos(Page<?> page, @Param("title") String title);

    /**
     * 这是一个MyBatis的查询注解，用于定义一个查询方法的SQL语句。
     * @param keyword
     * @return
     */
    @Select("""
            SELECT * FROM videos WHERE title LIKE CONCAT('%', #{keyword}, '%')
    """)
    List<Videos> search(String keyword);
    /**
     * Page<?>是MyBatis-Plus提供的一个分页参数，用于处理分页查询。
     * @Param("title")注解用于指定参数的名称，该名称在SQL语句中使用。
     * 方法的返回类型是IPage<Videos>，表示返回一个包含Videos对象的分页结果。
     * selectPagedVideos方法的作用是根据标题模糊查询视频列表，并分页返回结果。
     */
}




