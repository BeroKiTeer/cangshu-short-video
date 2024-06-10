package cn.edu.ujn.shortvideo.controller.socialize;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FollowsControllerTest {

    @Resource
    private FollowsController followsController;
    @Test
    void follow() {
        ApiResponse<?> follow = followsController.follow(1, 2);
        System.out.println(follow);
    }

    @Test
    void unfollow() {
        ApiResponse<?> unfollow = followsController.unfollow(2);
        System.out.println(unfollow);
    }
}