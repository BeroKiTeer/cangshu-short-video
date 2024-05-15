package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.Users;
import cn.edu.ujn.shortvideo.entities.dto.UsersLoginDTO;
import cn.edu.ujn.shortvideo.mapper.UsersMapper;
import jakarta.annotation.Resource;

public interface UserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public Users getUserById(Integer id);

    /**
     * 登录用户
     * @param usersLoginDTO
     * @return
     */
    Users login(UsersLoginDTO usersLoginDTO);
}
