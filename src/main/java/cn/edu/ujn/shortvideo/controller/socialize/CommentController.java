package cn.edu.ujn.shortvideo.controller.socialize;


import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Comments;
import cn.edu.ujn.shortvideo.service.CommentsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @param videoId 评论的视频ID，来自于URL路径变量。
     * @return 返回一个包含评论列表的ApiResponse对象，如果成功获取评论，则comments字段为评论列表。
     */
    @GetMapping("/video/{videoId}")
    public ApiResponse<List<Comments>> getCommentsByVideoId(@PathVariable int videoId) {
        // 通过视频ID从评论服务获取评论列表
        List<Comments> comments = commentsService.getCommentsByVideoId(videoId);
        // 构造并返回一个成功的API响应，包含获取到的评论列表
        return ApiResponse.success(comments);
    }

    /**
     * 更新评论信息。
     *
     * @param comment 包含更新信息的评论对象，通过请求体传入。
     * @return ApiResponse<Comments> 如果评论更新成功，返回包含更新后评论信息的ApiResponse对象；如果评论未找到，返回一个包含错误信息的ApiResponse对象。
     */
    @PutMapping("/{commentId}")
    public ApiResponse<Comments> updateComment(@PathVariable Integer commentId, @RequestBody Comments comment, @RequestParam Integer userId) {
        comment.setCommentId(commentId);
        Comments updatedComment = commentsService.updateComment(comment, userId);
        if (updatedComment != null) {
            return ApiResponse.success(updatedComment);
        } else {
            return ApiResponse.fail("Comment not found or not owned by user");
        }
    }

    /**
     * 根据视频ID和分页参数获取评论列表的API响应。
     *
     * @param videoId 视频的唯一标识符，用于查询该视频的评论。
     * @param pageNo 请求的页码，默认为1，表示从第一页开始。
     * @param pageSize 每页显示的评论数量，默认为10。
     * @return ApiResponse<IPage<Comments>> 包含评论分页信息的API响应对象。
     */
    @GetMapping("/video/{videoId}/page")
    public ApiResponse<IPage<Comments>> getCommentsByVideoIdWithPagination(
            @PathVariable int videoId,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {

        // 初始化分页对象
        Page<Comments> page = new Page<>(pageNo, pageSize);
        // 调用服务层方法，根据视频ID和分页参数获取评论分页信息
        IPage<Comments> commentsPage = commentsService.getCommentsByVideoIdWithPagination(page, videoId);
        // 返回成功的API响应，包含评论分页信息
        return ApiResponse.success(commentsPage);
    }
}