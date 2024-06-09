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
     * ??????获取的这些信息是怎么来的，哪个表是参考/哪个文件是参考？
     * upload和update有什么区别
     */
    @PostMapping//表示该方法将处理HTTP POST请求。
    public ApiResponse<Videos> uploadVideo(
            @RequestParam int userId,//这是方法的一个参数,表示该参数将从请求的查询参数中获取，参数名为userId，类型为int。
            @RequestParam String title,//从请求中获取视频的标题。
            @RequestParam String description,//获取视频的描述。
            @RequestParam String tags,//获取视频的标签。
            @RequestParam MultipartFile videoFile) {
        /**
         * 1.获取上传的视频文件。MultipartFile是Spring MVC提供的一个接口，用于表示上传的文件。
         * 这里使用@RequestParam注解来获取上传的文件，并将其赋值给videoFile变量。
         * 2.创建一个VideoDTO对象的构建器，并设置视频的属性，
         * 包括用户ID、标题、描述、标签和视频文件，然后构建并返回VideoDTO对象。
         */
        VideoDTO videoDTO = VideoDTO.builder()
                .userId(userId)
                .title(title)
                .description(description)
                .tags(tags)
                .videoFile(videoFile)
                .build();
        /**
         * 用videoService服务的uploadVideo方法，传入构建好的VideoDTO对象，
         * 该方法负责实际的视频上传逻辑，并将上传后的视频对象返回。
         */
        Videos video = videoService.uploadVideo(videoDTO);
        //返回一个成功的响应，其中包含上传的视频对象。
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
    //表示返回一个包含分页视频列表
    public ApiResponse<IPage<Videos>> getPagedVideos(
            @RequestParam int userId,//表示该参数将从请求的查询参数中获取，参数名为userId，类型为int。
            @RequestParam(defaultValue = "1") int page,//表示如果没有提供page参数，将默认使用值1。参数类型为int。
            @RequestParam(defaultValue = "10") int pageSize) {
        /**
         * 调用videoService服务的getPagedVideos方法，传入页码page、每页大小pageSize和用户IDuserId，
         * 该方法负责根据这些参数获取分页的视频列表，并将结果返回。
         */
        IPage<Videos> videoPage = videoService.getPagedVideos(page, pageSize, userId);

        return ApiResponse.success(videoPage);//返回一个成功的响应，其中包含分页的视频列表。
    }
}
