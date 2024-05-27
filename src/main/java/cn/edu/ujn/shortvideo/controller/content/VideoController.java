package cn.edu.ujn.shortvideo.controller.content;
import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import cn.edu.ujn.shortvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public ApiResponse<Videos> uploadVideo(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam MultipartFile videoFile) {
        Videos video = videoService.uploadVideo(title, description, videoFile);
        return ApiResponse.success(video);
    }

    @GetMapping("/{videoId}")
    public ApiResponse<Videos> getVideoDetails(@PathVariable int videoId) {
        Videos video = videoService.getVideoDetails(videoId);
        return ApiResponse.success(video);
    }

    @PutMapping("/{videoId}")
    public ApiResponse<Videos> updateVideo(
            @PathVariable int videoId,
            @RequestBody VideoDTO videoDTO) {
        Videos video = videoService.updateVideo(videoId, videoDTO);
        return ApiResponse.success(video);
    }

    @DeleteMapping("/{videoId}")
    public ApiResponse<String> deleteVideo(@PathVariable int videoId) {
        videoService.deleteVideo(videoId);
        return ApiResponse.success("Video deleted successfully");
    }
}
