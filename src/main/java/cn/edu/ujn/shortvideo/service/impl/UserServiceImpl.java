package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.common.constant.MessageConstant;
import cn.edu.ujn.shortvideo.common.constant.RoleConstant;
import cn.edu.ujn.shortvideo.common.constant.StatusConstant;
import cn.edu.ujn.shortvideo.common.exception.AccountAlreadyExistException;
import cn.edu.ujn.shortvideo.common.exception.AccountNotFoundException;
import cn.edu.ujn.shortvideo.common.exception.PasswordErrorException;
import cn.edu.ujn.shortvideo.entities.dox.Users;
import cn.edu.ujn.shortvideo.entities.dto.UsersDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersLoginDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersRegisterDTO;
import cn.edu.ujn.shortvideo.mapper.UsersMapper;
import cn.edu.ujn.shortvideo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Transactional
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
    /**
     * 用户登录
     * @param usersLoginDTO
     * @return
     */
    @Override
    public Users login(UsersLoginDTO usersLoginDTO) {
        // 查询数据库，判断用户名和密码是否正确
        String username = usersLoginDTO.getUsername();
        String password = usersLoginDTO.getHashedPassword();

        Users users = usersMapper.selectByUsername(username);

        // 判断用户是否存在
        if (users == null) {
            throw new AccountNotFoundException(MessageConstant.USER_NOT_EXIST);
        }

        // 判断密码是否正确
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(users.getHashedPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (users.getStatus() == StatusConstant.DISABLE) {
            throw new AccountNotFoundException(MessageConstant.USER_LOCKED);
        }

        return users;
    }

    /**
     * 修改密码
     * @param users
     * @return
     */
    @Override
    public UsersLoginDTO updatePassword(UsersLoginDTO users) {
        String username = users.getUsername();
        String password = users.getHashedPassword();
        Users users1 = usersMapper.selectByUsername(username);

        DigestUtils.md5DigestAsHex(password.getBytes());

        int i = usersMapper.updatePasswordById(users1.getUserId());

        Users users2 = usersMapper.selectById(users1.getUserId());

        return UsersLoginDTO.builder()
                .userId(users2.getUserId())
                .role(users2.getRole())
                .hashedPassword(users2.getHashedPassword())
                .username(users2.getUsername())
                .email(users2.getEmail())
                .build();
    }
    @Override
    public void register(UsersRegisterDTO usersRegisterDTO) {
        Users users = new Users();
        //对象属性拷贝     (源,目的)  前提是属性名一致
        BeanUtils.copyProperties(usersRegisterDTO, users);
        users.setRole(RoleConstant.ROLE_USER);
        users.setHashedPassword(DigestUtils.md5DigestAsHex(usersRegisterDTO.getPassword().getBytes()));

        // 判断用户名是否已存在
        if (usersMapper.selectByUsername(usersRegisterDTO.getUsername()) != null) {
            throw new AccountAlreadyExistException(MessageConstant.USER_ALREADY_EXIST);
        }

        usersMapper.insert(users);
    }
}
