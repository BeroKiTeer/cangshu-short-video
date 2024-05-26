package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Likes;
import cn.edu.ujn.shortvideo.mapper.LikesMapper;
import cn.edu.ujn.shortvideo.service.LikesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Service
public class LikesServiceImpl implements LikesService {
    @Resource
    private LikesMapper likesMapper;
    @Override
    public Likes getlikesById(Integer id) {
        return likesMapper.selectById(id);
    }

    @Override
    public Optional<Likes> likeVideo(Integer videoId, Integer userId) {
        // 检查用户对该视频是否已经点赞过
        Optional<Likes> existingLike = likesMapper.findByVideoIdAndUserId(videoId, userId);
        if (existingLike.isPresent()) {
            return existingLike;
        } else {
            // 创建新的点赞记录
            Likes like = new Likes();
            like.setVideoId(videoId);
            like.setUserId(userId);
            like.setCreatedAt(LocalDateTime.now());
            Likes savedLike = likesMapper.save(like);
            return Optional.ofNullable(savedLike);
        }
    }

    @Override
    public boolean unlikeVideo(Integer likeId) {
        // 根据likeId取消点赞
        if (likesMapper.existsById(likeId)) {
            likesMapper.deleteById(likeId);
            return true;
        } else {
            return false;
        }
    }



}
