package cn.edu.ujn.shortvideo.controller.content;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.controller.idm.UserController;
import cn.edu.ujn.shortvideo.entities.dox.Users;
import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
class VideoControllerTest {
    @Resource
    private VideoController videoController;
    @Resource
    private UserController userController;
    @Test
    void uploadVideo() {

        ApiResponse<Videos> videosApiResponse = videoController.uploadVideo(
                1,
                "http://localhost:8080/videos/1.mp4",
                "描述",
                "tags",
                null
        );

        System.out.println("videosApiResponse = " + videosApiResponse);
    }

    @Test
    void getVideoDetails() {
        ApiResponse<Videos> videosApiResponse = videoController.getVideoDetails(1);
        System.out.println("videosApiResponse = " + videosApiResponse);
    }

    @Test
    void updateVideo() {

        VideoDTO videoDTO = VideoDTO.builder()
                .videoId(1)
                .status("active")
                .title("123")
                .description("123description")
                .tags("123tags")
                .videoFile(null)
                .build();

        ApiResponse<Videos> videosApiResponse = videoController.updateVideo(
                1,
                videoDTO
        );

        System.out.println("videosApiResponse = " + videosApiResponse);
    }

    @Test
    void deleteVideo() {
        ApiResponse<String> videosApiResponse = videoController.deleteVideo(1);
        System.out.println("videosApiResponse = " + videosApiResponse);
    }

    @Test
    void getPagedVideos() {
        ApiResponse<IPage<Videos>> pagedVideos = videoController.getPagedVideos(1, 5, 5);
        System.out.println("pagedVideos = " + pagedVideos.getData());
    }
}