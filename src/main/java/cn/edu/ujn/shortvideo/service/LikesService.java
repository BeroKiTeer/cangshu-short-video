package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Likes;



public interface LikesService {
    Likes getlikesById(Integer id);
    boolean likeVideo(Integer videoId, Integer userId);
    boolean unlikeVideo(Integer likeId);
}
