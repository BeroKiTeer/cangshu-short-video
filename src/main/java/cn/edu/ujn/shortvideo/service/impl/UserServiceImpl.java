package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.Users;
import cn.edu.ujn.shortvideo.mapper.UsersMapper;
import cn.edu.ujn.shortvideo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Override
    public Users getUserById(Integer id) {
        return usersMapper.selectById(id);
    }
}
