package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Comments;


import java.util.List;

/**
 * 评论功能接口，提供对评论的增删查改操作以及权限检查功能。
 */
public interface CommentsService {
    /**
     * 添加一条新的评论。
     * @param comment
     * @return
     */
    Comments addComment(Comments comment);

    /**
     * 删除指定评论。
     * @param commentId
     */
    void deleteComment(int commentId);

    /**
     * 根据视频ID获取评论列表。
     * @param videoId
     * @return
     */
    List<Comments> getCommentsByVideoId(int videoId);

    /**
     * 更新评论
     * @param comment
     * @param userId
     * @return
     */
    Comments updateComment(Comments comment, Integer userId);

    /**
     * 分页获取指定视频的评论列表。
     *
     * @param videoId 视频的唯一标识ID。
     * @param page    要获取的评论页码。
     * @param size    每页评论的数量。
     * @return 返回指定视频ID、页码和每页大小的评论列表。
     */
    List<Comments> getCommentsByPage(int videoId, int page, int size);

    /**
     * 检查评论是否由指定用户拥有。
     *
     * @param commentId 评论的唯一标识ID。
     * @param userId    用户的唯一标识ID。
     * @return 如果评论由指定用户创建，返回true；否则返回false。
     */
    boolean isCommentOwnedByUser(int commentId, int userId);
}
