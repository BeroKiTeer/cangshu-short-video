package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Comments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface CommentsService {
    Comments addComment(Comments comment);
    void deleteComment(int commentId);
    List<Comments> getCommentsByVideoId(int videoId);
    Comments updateComment(Comments comment, Integer userId);
    IPage<Comments> getCommentsByVideoIdWithPagination(Page<Comments> page, int videoId);
}
