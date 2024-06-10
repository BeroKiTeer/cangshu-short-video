package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.common.exception.ResourceNotFoundException;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import cn.edu.ujn.shortvideo.entities.dox.Videos;

import cn.edu.ujn.shortvideo.mapper.UsersMapper;
import cn.edu.ujn.shortvideo.mapper.VideosMapper;
import cn.edu.ujn.shortvideo.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * 视频服务实现类
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideosMapper videosMapper;

    @Autowired
    private UsersMapper usersMapper; // 假设你有一个 UsersMapper 用于操作用户数据

    /**
     * 上传新视频
     * @param videoDTO 包含视频详情的数据传输对象
     * @return 上传的视频详情
     * 注意
     * 1.学习builder()方法
     */
    @Override
    public Videos uploadVideo(VideoDTO videoDTO) {
        // 验证用户ID是否存在
        if (usersMapper.selectById(videoDTO.getUserId()) == null) {
            throw new ResourceNotFoundException("用户不存在");
        }

        // 处理视频文件上传并生成URL
        String videoUrl = uploadFile(videoDTO.getVideoFile());
        String thumbnailUrl = generateThumbnail(videoUrl);

        // 创建视频实体
        Videos video = Videos.builder()
                .userId(videoDTO.getUserId())
                .title(videoDTO.getTitle())
                .description(videoDTO.getDescription())
                .tags(videoDTO.getTags())
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
     * 根据ID获取视频详情，
     * @param videoId 视频ID
     * @return 视频详情
     */
    @Override
    public Videos getVideoDetails(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("视频不存在");
        }
        return video;
    }

    /**
     * 更新现有的视频
     * @param videoDTO 包含更新后视频详情的数据传输对象
     * @return 更新后的视频详情
     */
    @Override
    public Videos updateVideo(VideoDTO videoDTO) {
        // 从数据库中通过视频ID获取现有的视频信息
        Videos existingVideo = videosMapper.selectById(videoDTO.getVideoId());

        // 如果视频不存在，抛出资源未找到异常
        if (existingVideo == null) {
            throw new ResourceNotFoundException("视频不存在");
        }

        // 创建一个新的视频对象，使用传入的DTO更新必要的字段，并保留现有视频的其他字段
        Videos updatedVideo = Videos.builder()
                .videoId(existingVideo.getVideoId())  // 保留现有视频ID
                .userId(existingVideo.getUserId())    // 保留现有用户ID
                .title(videoDTO.getTitle())           // 更新视频标题
                .description(videoDTO.getDescription()) // 更新视频描述
                .status(videoDTO.getStatus())         // 更新视频状态
                .thumbnailUrl(existingVideo.getThumbnailUrl()) // 保留现有缩略图URL
                .duration(existingVideo.getDuration()) // 保留现有视频时长
                .tags(existingVideo.getTags())         // 保留现有视频标签
                .createdAt(existingVideo.getCreatedAt()) // 保留视频创建时间
                .updatedAt(LocalDateTime.now())         // 更新视频更新时间为当前时间
                .build();

        // 将更新后的视频对象保存到数据库中
        videosMapper.updateById(updatedVideo);

        // 返回更新后的视频对象
        return updatedVideo;
    }


    /**
     * 根据ID删除视频
     * @param videoId 要删除的视频ID
     */
    @Override
    public void deleteVideo(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("视频不存在");
        }
        videosMapper.deleteById(videoId);
    }

    /**
     * 获取特定用户的视频分页列表
     * @param currentPage 当前页码
     * @param pageSize 每页视频数量
     * @param userId 用户ID
     * @return 分页的视频列表
     */
    @Override
    public IPage<Videos> getPagedVideos(int currentPage, int pageSize, int userId) {
        Page<Videos> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Videos> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return videosMapper.selectPage(page, queryWrapper);
    }

    /**
     * 处理文件上传
     * @param file 要上传的Multipart文件
     * @return 上传文件的URL
     */
    private String uploadFile(MultipartFile file) {
        // 实现文件上传逻辑并返回文件URL
        return "uploaded_file_url";
    }

    /**
     * 生成视频缩略图
     * @param videoUrl 视频URL
     * @return 生成的缩略图URL
     */
    private String generateThumbnail(String videoUrl) {
        // 实现缩略图生成逻辑并返回缩略图URL
        return "thumbnail_url";
    }
}
