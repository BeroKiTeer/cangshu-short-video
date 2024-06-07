package cn.edu.ujn.shortvideo.controller.socialize;

import cn.edu.ujn.shortvideo.common.result.ApiResponse;
import cn.edu.ujn.shortvideo.entities.dox.Comments;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentControllerTest {
    @Resource
    private CommentController commentController;

    @Test
    void addComment() {
        Comments comments = Comments.builder()
                .commentId(1)
                .videoId(1)
                .status("active")
                .text("hello world")
                .build();

        ApiResponse<Comments> commentsApiResponse = commentController.addComment(comments, 1);
        System.out.println("commentsApiResponse = " + commentsApiResponse);
    }

    @Test
    void deleteComment() {
        ApiResponse commentsApiResponse = commentController.deleteComment(1, 1);
        System.out.println("commentsApiResponse = " + commentsApiResponse);
    }

    @Test
    void getCommentsByVideoId() {
        ApiResponse<List<Comments>> commentsByVideoId = commentController.getCommentsByVideoId(1);

        System.out.println("commentsByVideoId = " + commentsByVideoId.getData());
    }

    @Test
    void updateComment() {
        Comments comments = Comments.builder()
                .commentId(1)
                .videoId(1)
                .status("active")
                .text("hello world")
                .build();

        ApiResponse<Comments> commentsApiResponse = commentController.updateComment(1,comments, 1);
        System.out.println("commentsApiResponse = " + commentsApiResponse);
    }

    @Test
    void getCommentsByPage() {

        ApiResponse<List<Comments>> commentsByPage = commentController.getCommentsByPage(1, 1,10);
        System.out.println("commentsByPage = " + commentsByPage.getData());
    }
}