package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Comments;

import java.util.List;

public interface CommentsService {
    Comments addComment(Comments comment);
    void deleteComment(int commentId);
    List<Comments> getCommentsByVideoId(int videoId);
    Comments updateComment(Comments comment);
}
