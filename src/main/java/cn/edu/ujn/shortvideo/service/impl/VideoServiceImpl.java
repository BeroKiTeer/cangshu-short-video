package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.common.exception.ResourceNotFoundException;
import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import cn.edu.ujn.shortvideo.mapper.VideosMapper;
import cn.edu.ujn.shortvideo.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * 视频上传、获取视频详情、更新视频信息和删除视频的实现类
 * @author ff
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideosMapper, Videos> implements VideoService {

    @Autowired
    private VideosMapper videosMapper;

    /**
     * 根据视频ID获取视频详情
     */
    @Override
    public Videos uploadVideo(String title, String description, MultipartFile videoFile) {
        // Implement file upload logic here and generate videoUrl and thumbnailUrl
        String videoUrl = ""; // Upload the file and get the URL
        String thumbnailUrl = ""; // Generate thumbnail and get the URL

        Videos video = Videos.builder()
                .title(title)
                .description(description)
                .videoUrl(videoUrl)
                .thumbnailUrl(thumbnailUrl)
                .status("public")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        videosMapper.insert(video);
        return video;
    }
    /**
    * 获取视频详情
    */
    @Override
    public Videos getVideoDetails(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("Video not found");
        }
        return video;
    }

    /**
     * 更新视频
     */
    public Videos updateVideo(VideoDTO videoDTO) {
        Videos existingVideo = videosMapper.selectById(videoDTO.getVideoId());
        if (existingVideo == null) {
            throw new ResourceNotFoundException("Video not found");
        }

        Videos updatedVideo = Videos.builder()
                .videoId(existingVideo.getVideoId())
                .userId(existingVideo.getUserId())
                .title(videoDTO.getTitle())
                .description(videoDTO.getDescription())
                .status(videoDTO.getStatus())
                .thumbnailUrl(existingVideo.getThumbnailUrl())
                .duration(existingVideo.getDuration())
                .tags(existingVideo.getTags())
                .createdAt(existingVideo.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        int ret = videosMapper.updateById(updatedVideo);

        return updatedVideo;
    }

    /**
     * 删除视频
     */
    @Override
    public void deleteVideo(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("Video not found");
        }

        videosMapper.deleteById(videoId);
    }

    /**
     *  实现分页查询方法
     */
    @Override
    public IPage<Videos> getPagedVideos(int currentPage, int pageSize, int userId) {
        // 创建分页对象
        Page<Videos> page = new Page<>(currentPage, pageSize);
        // 创建查询条件
        QueryWrapper<Videos> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        // 执行分页查询
        return videosMapper.selectPage(page, queryWrapper);

    }
}
