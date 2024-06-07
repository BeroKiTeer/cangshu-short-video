package cn.edu.ujn.shortvideo.controller.socialize;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Likes;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LikesControllerTest {

    @Resource
    private LikesController likesController;

    @Test
    void getLikesById() {
        ApiResponse<Likes> likesById = likesController.getLikesById(1);

        System.out.println(likesById);
    }

    @Test
    void likeVideo() {

        // 测试点赞
        ApiResponse<String> likesById = likesController.likeVideo(1,1);

        System.out.println(likesById);
    }

    @Test
    void unlikeVideo() {

        // 测试取消点赞
        ApiResponse<String> likesById = likesController.unlikeVideo(1);

        System.out.println(likesById);
    }
}