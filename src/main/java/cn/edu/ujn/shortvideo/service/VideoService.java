package cn.edu.ujn.shortvideo.service;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.entities.dto.VideoDTO;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
    Videos uploadVideo(String title, String description, MultipartFile videoFile);
    Videos getVideoDetails(int videoId);
    Videos updateVideo(int videoId, VideoDTO videoDTO);
    void deleteVideo(int videoId);
}
