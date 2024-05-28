package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Likes;
import cn.edu.ujn.shortvideo.mapper.LikesMapper;
import cn.edu.ujn.shortvideo.service.LikesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Transactional
@Service
public class LikesServiceImpl implements LikesService {
    @Resource
    private LikesMapper likesMapper;
    @Override
    public Likes getlikesById(Integer id) {
        return likesMapper.selectById(id);
    }

    /**
     *
     * @param videoId
     * @param userId
     * @return
     */
    @Override
    public boolean likeVideo(Integer videoId, Integer userId) {
        // 检查用户是否已经点赞视频
        Likes existingLike = likesMapper.findByVideoIdAndUserId(videoId, userId);
        if (existingLike != null) {
            return false; // 用户已经点赞
        } else {
            // 创建新的点赞记录
            Likes like = new Likes();
            like.setVideoId(videoId);
            like.setUserId(userId);
            like.setCreatedAt(LocalDateTime.now());
            likesMapper.save(like);
            return true; // 成功点赞
        }
    }

    /**
     *
     * @param likeId
     * @return
     */
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
