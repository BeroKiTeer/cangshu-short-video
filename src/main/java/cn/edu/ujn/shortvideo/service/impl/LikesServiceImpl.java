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
    /**
     * 根据ID获取点赞信息。
     *
     * @param id 点赞记录的唯一标识符。这是一个整数类型，非空。
     * @return 返回与给定ID匹配的点赞信息。如果找不到匹配的记录，则返回null。
     */
    @Override
    public Likes getlikesById(Integer id) {
        return likesMapper.selectById(id);
    }

    /**
     * 用户点赞视频接口。
     *
     * @param videoId 视频的唯一标识符。
     * @param userId 用户的唯一标识符。
     * @return 如果点赞成功，返回true；如果用户已经点赞过该视频，返回false。
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
     * 取消点赞视频。
     *
     * 本方法用于取消对特定视频的点赞。它首先检查给定的点赞ID是否存在，
     * 如果存在，则删除该点赞记录，并返回true表示取消点赞成功；
     * 如果不存在，则返回false，表示取消点赞失败，可能是因为该点赞ID不存在。
     *
     * @param likeId 点赞的唯一标识ID。这个ID用于在数据库中定位到特定的点赞记录。
     * @return 如果取消点赞成功，返回true；如果取消点赞失败，返回false。
     */
    @Override
    public boolean unlikeVideo(Integer likeId) {
        // 检查点赞ID是否存在
        // 根据likeId取消点赞
        if (likesMapper.existsById(likeId)) {
            // 如果点赞ID存在，则删除该点赞记录
            likesMapper.deleteById(likeId);
            return true;
        } else {
            return false;
        }
    }



}
