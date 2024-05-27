package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.common.exception.ResourceNotFoundException;
import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import cn.edu.ujn.shortvideo.mapper.VideosMapper;
import cn.edu.ujn.shortvideo.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class VideoServiceImpl extends ServiceImpl<VideosMapper, Videos> implements VideoService {

    @Autowired
    private VideosMapper videosMapper;

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

    @Override
    public Videos getVideoDetails(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("Video not found");
        }
        return video;
    }

    public Videos updateVideo(int videoId, VideoDTO videoDTO) {
        Videos existingVideo = videosMapper.selectById(videoId);
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

        videosMapper.updateById(updatedVideo);

        return updatedVideo;
    }

    @Override
    public void deleteVideo(int videoId) {
        Videos video = videosMapper.selectById(videoId);
        if (video == null) {
            throw new ResourceNotFoundException("Video not found");
        }

        videosMapper.deleteById(videoId);
    }
}
