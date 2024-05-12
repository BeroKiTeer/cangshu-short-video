package cn.edu.ujn.shortvideo.controller.idm;

import cn.edu.ujn.shortvideo.common.constant.MessageConstant;
import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.Users;
import cn.edu.ujn.shortvideo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public ApiResponse<Users> getUserInfo(@PathVariable("userId") Integer userId) {
        Users users = userService.getUserById(userId);
        if(users == null) {
            return ApiResponse.fail(MessageConstant.USER_NOT_EXIST);
        }
        return ApiResponse.success(users);
    }
}
