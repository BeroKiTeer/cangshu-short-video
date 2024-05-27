package cn.edu.ujn.shortvideo.mapper;

import cn.edu.ujn.shortvideo.entities.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author dell
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-05-11 14:51:39
* @Entity generator.domain.Users
*/
public interface UsersMapper extends BaseMapper<Users> {

    @Select("select * from users where username = #{username}")
    Users selectByUsername(String username);

    @Update("update users set hashed_password = #{password} where user_id = #{userId}")
    int updatePasswordById(Integer userId);
}




