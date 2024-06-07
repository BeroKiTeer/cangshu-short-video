package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Users;
import cn.edu.ujn.shortvideo.entities.dto.UsersDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersLoginDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersRegisterDTO;

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

    /**
     * 修改密码
     * @param users
     * @return
     */
    UsersLoginDTO updatePassword(UsersLoginDTO users);
    /**
     * 注册用户
     * @param usersRegisterDTO
     */
    void register(UsersRegisterDTO usersRegisterDTO);

    Users updateUserInfo(UsersDTO usersDTO);
}
