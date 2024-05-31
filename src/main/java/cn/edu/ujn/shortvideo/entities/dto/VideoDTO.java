package cn.edu.ujn.shortvideo.entities.dto;

import lombok.Data;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

/**
 * 视频数据传输对象
 */
@Data
@Builder
public class VideoDTO {
    private Integer videoId;      // 视频ID
    private Integer userId;       // 用户ID
    private String title;         // 视频标题
    private String description;   // 视频描述
    private String tags;          // 视频标签
    private String status;        // 视频状态
    private MultipartFile videoFile; // 视频文件
}
