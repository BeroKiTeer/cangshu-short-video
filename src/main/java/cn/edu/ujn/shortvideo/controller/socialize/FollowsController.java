package cn.edu.ujn.shortvideo.controller.socialize;


import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.service.FollowsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/follows")
public class FollowsController {

    @Resource
    private FollowsService followsService;

    /**
     * 处理用户关注操作的请求。
     *
     * @param followerId 关注者的用户ID。
     * @param followedId 被关注者的用户ID。
     * @return 返回一个表示操作成功的ApiResponse对象。
     */
    @PostMapping
    public ApiResponse<?> follow(@RequestParam int followerId, @RequestParam int followedId) {
        // 调用服务层方法，执行关注操作
        followsService.follow(followerId, followedId);
        // 返回成功响应
        return ApiResponse.success();
    }

    /**
     * 取消关注操作。
     *
     * @param followId 要取消关注的用户ID，来自URL路径变量。
     * @return 返回一个成功的API响应，表明取消关注操作已完成。
     */
    @DeleteMapping("/{followId}")
    public ApiResponse<?> unfollow(@PathVariable int followId) {
        // 调用服务层方法，执行取消关注操作
        followsService.unfollow(followId);
        // 返回成功响应
        return ApiResponse.success();
    }
}
