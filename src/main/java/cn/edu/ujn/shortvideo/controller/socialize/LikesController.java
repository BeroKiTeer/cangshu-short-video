package cn.edu.ujn.shortvideo.controller.socialize;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Likes;
import cn.edu.ujn.shortvideo.service.LikesService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LikesController {
    @Resource
    private LikesService likesService;

    /**
     * 通过指定的ID获取点赞信息。
     *
     * @param id 指定的点赞信息ID，不能为空。
     * @return ApiResponse<Likes> 包含点赞信息的API响应对象。如果成功找到点赞信息，则包含点赞信息对象；如果找不到，则可能返回一个空的或错误的响应体。
     */
    @GetMapping("/api/likes/{likeId}")
    @ResponseBody
    public ApiResponse<Likes> getLikesById(@PathParam("id") Integer id) {
        Likes likes = likesService.getlikesById(id);
        return ApiResponse.success(likes);
    }
    /**
     * 用户点赞视频的API接口。
     *
     * @param videoId 视频的ID，用于标识要点赞的视频。
     * @param userId 用户的ID，用于标识进行点赞操作的用户。
     * @return ApiResponse<Likes> 如果点赞成功，返回包含点赞信息的ApiResponse对象；如果用户已经点赞过，返回一个失败的ApiResponse对象。
     */
    @PostMapping("/api/likes")
    @ResponseBody
    public ApiResponse<Likes> likeVideo(@RequestParam Integer videoId, @RequestParam Integer userId) {
        return likesService.likeVideo(videoId, userId)
                .map(ApiResponse::success)
                .orElse(ApiResponse.fail("用户已经点过赞了"));
    }
    /**
     * 处理取消点赞的请求。
     *
     * @param likeId 点赞记录的ID，用于标识需要取消点赞的视频。
     * @return 返回一个API响应对象，如果取消点赞成功，则包含成功消息；如果点赞记录不存在，则包含失败消息。
     */
    @DeleteMapping("/api/likes/{likeId}")
    @ResponseBody
    public ApiResponse<String> unlikeVideo(@PathVariable Integer likeId) {
        boolean success = likesService.unlikeVideo(likeId);
        if (success) {
            return ApiResponse.success("取消点赞成功");
        } else {
            return ApiResponse.fail("点赞记录不存在");
        }
    }






}
