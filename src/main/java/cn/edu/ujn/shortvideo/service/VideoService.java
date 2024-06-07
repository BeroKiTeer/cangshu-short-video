package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * VideoService接口定义用于处理视频操作的方法。
 * 该接口包括视频上传、获取视频详情、更新视频信息和删除视频等功能。
 * @author ff
 */
public interface VideoService {
    /**
     * 上传新视频
     * @param videoDTO 包含视频详情的数据传输对象
     * @return 上传的视频详情
     */
    Videos uploadVideo(VideoDTO videoDTO);

    /**
     * 根据ID来获取视频详情
     * @param videoId 视频ID
     * @return 视频详情
     */
    Videos getVideoDetails(int videoId);

    /**
     * 更新现有视频
     * @param videoDTO 包含更新后视频详情的数据传输对象
     * @return 更新后的视频详情
     */
    Videos updateVideo(VideoDTO videoDTO);

    /**
     * 根据ID删除视频
     * @param videoId 要删除的视频ID
     */
    void deleteVideo(int videoId);
    

    /**
     * 获取特定用户的视频分页列表
     * @param currentPage 当前页码
     * @param pageSize 每页视频数量
     * @param userId 用户ID
     * @return 分页的视频列表
     */
    IPage<Videos> getPagedVideos(int currentPage, int pageSize, int userId);
}
