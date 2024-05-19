package cn.edu.ujn.shortvideo.service.impl;

import cn.edu.ujn.shortvideo.entities.dox.Videos;
import cn.edu.ujn.shortvideo.mapper.VideosMapper;
import cn.edu.ujn.shortvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideosMapper videosMapper;

    private final String UPLOAD_DIR = "path/to/upload/dir/";

    @Override
    public void uploadVideo(String title, String description, MultipartFile file, MultipartFile thumbnail,
                            String status, String tags, int duration, int userId) throws Exception {
        // Save the video file
        String videoFileName = saveFile(file);

        // Save the thumbnail file
        String thumbnailFileName = saveFile(thumbnail);

        // Create a new video entity
        Videos videos = Videos.builder()
                .userId(userId)
                .title(title)
                .description(description)
                .videoUrl(videoFileName)
                .thumbnailUrl(thumbnailFileName)
                .status(status)
                .tags(tags)
                .duration(duration)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // Save the video entity to the database
        videosMapper.insert(videos);
    }

    private String saveFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("文件为空");
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.write(path, file.getBytes());

        return fileName;
    }
}
