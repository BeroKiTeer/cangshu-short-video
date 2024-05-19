package cn.edu.ujn.shortvideo.controller.content;
import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/upload")
    public ApiResponse<String> uploadVideo(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file,
            @RequestParam("thumbnail") MultipartFile thumbnail,
            @RequestParam("status") String status,
            @RequestParam("tags") String tags,
            @RequestParam("duration") int duration,
            @RequestParam("user_id") int userId) {

        try {
            videoService.uploadVideo(title, description, file, thumbnail, status, tags, duration, userId);
            return ApiResponse.success("视频上传成功");
        } catch (Exception e) {
            return ApiResponse.fail(e.getMessage());
        }
    }
}
