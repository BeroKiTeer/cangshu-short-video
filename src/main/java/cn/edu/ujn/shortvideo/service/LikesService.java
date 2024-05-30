package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Likes;

import java.util.Optional;

public interface LikesService {
    Likes getlikesById(Integer id);

    Optional<Likes> likeVideo(Integer videoId, Integer userId);
    boolean unlikeVideo(Integer likeId);
}
