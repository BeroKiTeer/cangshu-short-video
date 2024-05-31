package cn.edu.ujn.shortvideo.controller.content;
import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import cn.edu.ujn.shortvideo.service.VideoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频管理
 * @author ff
 */
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 上传视频
     */
    @PostMapping
    public ApiResponse<Videos> uploadVideo(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam MultipartFile videoFile) {
        Videos video = videoService.uploadVideo(title, description, videoFile);
        return ApiResponse.success(video);
    }

    /**
     * 根据视频ID获取视频详细信息
     */
    @GetMapping("/{videoId}")
    public ApiResponse<Videos> getVideoDetails(@PathVariable int videoId) {
        Videos video = videoService.getVideoDetails(videoId);
        return ApiResponse.success(video);
    }

    /**
     * 更新视频信息，包括标题、描述和文件
     */
    @PutMapping("/{videoId}")
    public ApiResponse<Videos> updateVideo(
            @PathVariable int videoId,
            @RequestBody VideoDTO videoDTO) {
        Videos video = videoService.updateVideo(videoDTO);
        return ApiResponse.success(video);
    }

    /**
     * 删除视频，根据视频ID
     */
    @DeleteMapping("/{videoId}")
    public ApiResponse<String> deleteVideo(@PathVariable int videoId) {
        videoService.deleteVideo(videoId);
        return ApiResponse.success("Video deleted successfully");
    }

    /**
     * 新增分页查询接口
     */
    @GetMapping
    public ApiResponse<IPage<Videos>> getPagedVideos(
            @RequestParam int userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        IPage<Videos> videoPage = videoService.getPagedVideos(page, pageSize, userId);
        return ApiResponse.success(videoPage);
    }
}
