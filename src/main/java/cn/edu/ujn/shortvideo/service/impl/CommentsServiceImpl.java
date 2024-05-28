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
     *
     * @param comments
     * @return
     */
    @Override
    public Comments addComment(Comments comments) {
        commentsMapper.insertComment(comments);
        return comments;
    }

    /**
     *
     * @param commentId
     */
    @Override
    public void deleteComment(int commentId) {
        commentsMapper.deleteComment(commentId);
    }

    /**
     *
     * @param videoId
     * @return
     */
    @Override
    public List<Comments> getCommentsByVideoId(int videoId) {
        return commentsMapper.selectCommentsByVideoId(videoId);
    }
}
