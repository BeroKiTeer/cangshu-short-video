package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * VideoService接口定义了用于处理视频操作的方法。
 * 该接口包括视频上传、获取视频详情、更新视频信息和删除视频等功能。
 * @author ff
 */
public interface VideoService {
    Videos uploadVideo(String title, String description, MultipartFile videoFile);
    Videos getVideoDetails(int videoId);
    Videos updateVideo(VideoDTO videoDTO);
    void deleteVideo(int videoId);
}
