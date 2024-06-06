package cn.edu.ujn.shortvideo.controller.idm;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Users;
import cn.edu.ujn.shortvideo.entities.dto.UsersDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersLoginDTO;
import cn.edu.ujn.shortvideo.entities.dto.UsersRegisterDTO;
import cn.edu.ujn.shortvideo.entities.vo.UsersLoginVO;
import cn.edu.ujn.shortvideo.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    @Resource
    private UserController userController;
    @Test
    void getUserInfo() {
        ApiResponse<Users> userInfo = userController.getUserInfo(1);
        System.out.println("userInfo = " + userInfo);
    }

    @Test
    void login() {
        UsersLoginDTO usersLoginDTO = UsersLoginDTO.builder()
                .email("123456@qq.com")
                .role("user")
                .hashedPassword("123456")
                .build();
        ApiResponse<UsersLoginVO> login = userController.login(usersLoginDTO);
        System.out.println("login = " + login);
    }

    @Test
    void register(){
        UsersRegisterDTO registerDTO = UsersRegisterDTO.builder()
                .email("123456@qq.com")
                .password("123456")
                .username("username")
                .build();
        userController.register(registerDTO);
    }
}