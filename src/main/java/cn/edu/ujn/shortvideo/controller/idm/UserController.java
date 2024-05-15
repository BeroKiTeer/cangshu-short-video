package cn.edu.ujn.shortvideo.controller.idm;

import cn.edu.ujn.shortvideo.common.constant.MessageConstant;
import cn.edu.ujn.shortvideo.common.properties.JwtProperties;
import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.common.utils.JwtUtil;
import cn.edu.ujn.shortvideo.entities.Users;
import cn.edu.ujn.shortvideo.entities.dto.UsersLoginDTO;
import cn.edu.ujn.shortvideo.entities.vo.UsersLoginVO;
import cn.edu.ujn.shortvideo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public ApiResponse<UsersLoginVO> login(@RequestBody UsersLoginDTO usersLoginDTO) {
        Users users = userService.login(usersLoginDTO);

        Map<String, Object>claims = new HashMap<>();
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        UsersLoginVO usersLoginVO = UsersLoginVO.builder()
                .userId(users.getUserId())
                .username(users.getUsername())
                .role(users.getRole())
                .token(token)
                .build();


        return ApiResponse.success(usersLoginVO);
    }

    @GetMapping("/{userId}")
    public ApiResponse<Users> getUserInfo(@PathVariable("userId") Integer userId) {
        Users users = userService.getUserById(userId);
        if(users == null) {
            return ApiResponse.fail(MessageConstant.USER_NOT_EXIST);
        }
        return ApiResponse.success(users);
    }
}
