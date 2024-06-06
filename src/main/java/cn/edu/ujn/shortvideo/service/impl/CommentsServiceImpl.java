package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Comments;
import cn.edu.ujn.shortvideo.mapper.CommentsMapper;
import cn.edu.ujn.shortvideo.service.CommentsService;
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
     * 该方法用于根据提供的评论对象和用户ID来更新已存在的评论记录。如果评论存在且由指定用户创建，则更新评论并返回更新后的评论对象；否则，返回null。
     *
     * @param comment 包含更新后评论信息的对象，包括评论ID等标识信息。
     * @param userId  指定用户的ID，用于验证评论的归属权。
     * @return 返回更新后的评论对象，如果评论不存在或用户无权更新，则返回null。
     */
    @Override
    public Comments updateComment(Comments comment, Integer userId) {
        // 根据评论ID查询数据库中是否存在对应的评论记录
        // 检查原有评论是否存在，并且是否由提供的用户ID创建
        Comments existingComment = commentsMapper.selectById(comment.getCommentId());
        // 检查评论是否存在且属于指定用户
        if (existingComment != null && existingComment.getUserId().equals(userId)) {
            // 如果条件满足，则更新数据库中的评论记录
            commentsMapper.updateById(comment);
            // 查询更新后的评论记录并返回
            return commentsMapper.selectById(comment.getCommentId());
        }
        // 如果评论不存在或用户无权更新，则返回null
        return null;
    }



    /**
     * 根据视频ID和分页信息获取评论列表
     * @param videoId 视频ID，用于指定获取哪个视频的评论
     * @param page 请求的页码，用于计算偏移量和限定返回评论的数量
     * @param size 每页显示的评论数量
     * @return 返回一个评论列表，该列表包含了指定视频ID、页码和每页数量的评论信息
     */
    @Override
    public List<Comments> getCommentsByPage(int videoId, int page, int size) {
        // 计算查询偏移量，用于数据库查询时的偏移定位
        int offset = (page - 1) * size;
        // 调用commentsMapper的selectCommentsByPage方法，根据视频ID、偏移量和每页大小获取评论列表
        return commentsMapper.selectCommentsByPage(videoId, offset, size);
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

