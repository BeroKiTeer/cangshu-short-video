package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Comments;
import cn.edu.ujn.shortvideo.mapper.CommentsMapper;
import cn.edu.ujn.shortvideo.service.CommentsService;
import jakarta.annotation.Resource;

import java.util.List;

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
    public Comments updateComment(Comments comment) {
        // 通过ID更新评论信息
        commentsMapper.updateById(comment);
        // 根据ID重新获取并返回更新后的评论对象
        return commentsMapper.selectById(comment.getCommentId());
    }

}
