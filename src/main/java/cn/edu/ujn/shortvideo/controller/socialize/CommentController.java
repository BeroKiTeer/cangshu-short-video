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
     * @param userId 当前用户的ID，通过请求参数传入
     * @return ApiResponse<Comments> 返回添加成功的评论以及相关状态信息
     */
    @PostMapping
    public ApiResponse<Comments> addComment(@RequestBody Comments comments, @RequestParam Integer userId) {
        comments.setUserId(userId);
        Comments addedComment = commentsService.addComment(comments);
        return ApiResponse.success(addedComment);
    }

    /**
     * 删除指定ID的评论。
     *
     * @param commentId 评论的唯一标识符，来自URL路径变量。
     * @param userId 当前用户的ID，通过请求参数传入
     * @return 返回一个表示操作成功的ApiResponse<Void>对象。
     */
    @DeleteMapping("/{commentId}")
    public ApiResponse<Void> deleteComment(@PathVariable int commentId, @RequestParam Integer userId) {
        if (!commentsService.isCommentOwnedByUser(commentId, userId)) {
            return ApiResponse.fail("Comment not owned by user");
        }
        commentsService.deleteComment(commentId);
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
        List<Comments> comments = commentsService.getCommentsByVideoId(videoId);
        return ApiResponse.success(comments);
    }

    /**
     * 更新评论信息。
     *
     * @param comment 包含更新信息的评论对象，通过请求体传入。
     * @param userId 当前用户的ID，通过请求参数传入
     * @return ApiResponse<Comments> 如果评论更新成功，返回包含更新后评论信息的ApiResponse对象；如果评论未找到，返回一个包含错误信息的ApiResponse对象。
     */
    @PutMapping("/{commentId}")
    public ApiResponse<Comments> updateComment(@PathVariable Integer commentId, @RequestBody Comments comment, @RequestParam Integer userId) {
        if (!commentsService.isCommentOwnedByUser(commentId, userId)) {
            return ApiResponse.fail("Comment not owned by user");
        }
        comment.setCommentId(commentId);
        comment.setUserId(userId);
        Comments updatedComment = commentsService.updateComment(comment, userId);
        if (updatedComment != null) {
            return ApiResponse.success(updatedComment);
        } else {
            return ApiResponse.fail("Comment not found or not owned by user");
        }
    }

    /**
     * 根据视频ID和分页信息获取评论列表。
     *
     * @param videoId 视频ID，用于指定获取哪个视频的评论。
     * @param page 请求的页码，默认为第1页。
     * @param size 每页显示的评论数量，默认为10条。
     * @return ApiResponse<List<Comments>> 包含评论列表的API响应对象，成功时comments字段包含评论列表。
     */
    @GetMapping("/comments")
    public ApiResponse<List<Comments>> getCommentsByPage(
            @RequestParam int videoId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // 通过视频ID、页码和每页数量，从服务层获取评论列表
        List<Comments> comments = commentsService.getCommentsByPage(videoId, page, size);
        // 构建并返回一个包含评论列表的成功响应
        return ApiResponse.success(comments);
    }
}
