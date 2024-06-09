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
     * Builder 模式通过链式方法调用来创建对象，提供了一个灵活且可读性强的对象构建方式。
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
                .userId(videoDTO.getUserId())                // 设置用户ID
                .title(videoDTO.getTitle())                  // 设置视频标题
                .description(videoDTO.getDescription())      // 设置视频描述
                .tags(videoDTO.getTags())                    // 设置视频标签
                .videoUrl(videoUrl)                          // 设置视频URL
                .thumbnailUrl(thumbnailUrl)                  // 设置缩略图URL
                .status("public")                            // 设置视频状态（公开）
                .createdAt(LocalDateTime.now())              // 设置视频创建时间
                .updatedAt(LocalDateTime.now())              // 设置视频更新时间
                .build();                                    // 构建视频实体

        videosMapper.insert(video);
        return video;
    }

    /**
     * 根据ID获取视频详情，
     * @param videoId 视频ID
     * @return 视频详情
     * ？？？？？这个get以后干什么
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
     * 更新现有视频
     * @param videoDTO 包含更新后视频详情的数据传输对象
     * @return 更新后的视频详情
     * 接收一个包含视频更新信息的VideoDTO对象，
     * 找到对应的视频记录，更新其信息，并将更新后的视频对象返回。
     * 如果找不到对应的视频记录，将抛出异常。
     */
    @Override
    public Videos updateVideo(VideoDTO videoDTO) {
        /**调用videosMapper的selectById方法，根据videoDTO中的视频ID查找现有的视频对象。
         * 如果找到，就将其赋值给existingVideo变量。
        */
        Videos existingVideo = videosMapper.selectById(videoDTO.getVideoId());
        //检查是否找到了视频对象。
        if (existingVideo == null) {
            throw new ResourceNotFoundException("视频不存在");
        }
        /**
         * 创建一个新的Videos对象构建器
         * 并将existingVideo的属性值复制到构建器中。
         * 这样，updatedVideo变量将包含更新后的视频对象。
         */
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

        videosMapper.updateById(updatedVideo);
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
     * ？？？？这个和下面那个干啥的？
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
