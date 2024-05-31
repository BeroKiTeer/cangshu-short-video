package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Comments;
import cn.edu.ujn.shortvideo.mapper.CommentsMapper;
import cn.edu.ujn.shortvideo.service.CommentsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsMapper commentsMapper;

    /**
     * 添加一条评论到数据库。
     *
     * @param comments 评论对象，包含评论的详细信息。
     * @return 返回添加的评论对象。
     */
    @Override
    public Comments addComment(Comments comments) {
        // 将评论插入到数据库
        commentsMapper.insertComment(comments);
        return comments;
    }


    /**
     * 删除指定ID的评论。
     *
     * @param commentId 评论的唯一标识符，用于指定要删除的评论。
     */
    @Override
    public void deleteComment(int commentId) {
        // 通过调用commentsMapper的deleteComment方法，删除指定ID的评论
        commentsMapper.deleteComment(commentId);
    }


    /**
     * 根据视频ID获取评论列表。
     *
     * @param videoId 视频的唯一标识符。
     * @return 返回与指定视频ID相关联的评论列表。
     */
    @Override
    public List<Comments> getCommentsByVideoId(int videoId) {
        // 通过视频ID从数据库中查询所有的评论
        return commentsMapper.selectCommentsByVideoId(videoId);
    }


    /**
     * 更新评论信息。
     *
     * @param comment 包含更新后评论信息的对象。
     * @return 返回更新后的评论对象。
     */
    @Override
    public Comments updateComment(Comments comment, Integer userId) {
        Comments existingComment = commentsMapper.selectById(comment.getCommentId());
        if (existingComment != null && existingComment.getUserId().equals(userId)) {
            commentsMapper.updateById(comment);
            return commentsMapper.selectById(comment.getCommentId());
        }
        return null;
    }

    /**
     * 根据视频ID和分页参数获取评论列表。
     *
     * @param page 分页参数，包含当前页数和每页的记录数。
     * @param videoId 视频的唯一标识符。
     * @return 返回一个IPage<Comments>对象，包含当前页的评论列表。
     */
    @Override
    public IPage<Comments> getCommentsByVideoIdWithPagination(Page<Comments> page, int videoId) {
        // 调用commentsMapper，根据视频ID和分页参数查询评论
        return commentsMapper.selectCommentsByVideoIdWithPagination(page, videoId);
    }
    /**
     * 检查评论是否为指定用户所有。
     *
     * @param commentId 评论的ID，用于标识特定的评论。
     * @param userId 用户的ID，用于标识评论的归属用户。
     * @return 返回一个布尔值，如果评论为指定用户所有，则返回true；否则返回false。
     */
    @Override
    public boolean isCommentOwnedByUser(int commentId, int userId) {
        // 通过commentsMapper检查评论是否为用户所有
        return commentsMapper.isCommentOwnedByUser(commentId, userId);
    }
}

