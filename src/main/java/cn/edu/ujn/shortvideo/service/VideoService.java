package cn.edu.ujn.shortvideo.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ff
 */
public interface VideoService {
    void uploadVideo(String title, String description, MultipartFile file, MultipartFile thumbnail,
                     String status, String tags, int duration, int userId) throws Exception;
}
