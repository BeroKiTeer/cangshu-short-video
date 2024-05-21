package cn.edu.ujn.shortvideo.controller.socialize;


import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Comments;
import cn.edu.ujn.shortvideo.service.CommentsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Resource
    private CommentsService commentsService;

    /**
     * 添加评论
     *
     * @param comments 包含评论内容的对象，通过请求体传入
     * @return ApiResponse<Comments> 返回添加成功的评论以及相关状态信息
     */
    @PostMapping
    public ApiResponse<Comments> addComment(@RequestBody Comments comments) {
        // 通过服务层添加评论
        Comments addedComment = commentsService.addComment(comments);
        // 构建并返回成功响应
        return ApiResponse.success(addedComment);
    }

    /**
     * 删除指定ID的评论。
     *
     * @param commentId 评论的唯一标识符，来自URL路径变量。
     * @return 返回一个表示操作成功的ApiResponse<Void>对象。
     */
    @DeleteMapping("/{commentId}")
    public ApiResponse<Void> deleteComment(@PathVariable int commentId) {
        // 调用评论服务，删除指定ID的评论
        commentsService.deleteComment(commentId);
        // 返回成功响应
        return ApiResponse.success();
    }

    /**
     * 根据视频ID获取评论列表。
     *
     * @param videoId 需要获取评论的视频ID，来自于URL路径变量。
     * @return 返回一个包含评论列表的ApiResponse对象，如果成功获取评论，则comments字段为评论列表。
     */
    @GetMapping("/video/{videoId}")
    public ApiResponse<List<Comments>> getCommentsByVideoId(@PathVariable int videoId) {
        // 通过视频ID从评论服务获取评论列表
        List<Comments> comments = commentsService.getCommentsByVideoId(videoId);
        // 构造并返回一个成功的API响应，包含获取到的评论列表
        return ApiResponse.success(comments);
    }
}