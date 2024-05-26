package cn.edu.ujn.shortvideo.entities.dox;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Video 实体类，表示视频对象的基本信息
 * 包括视频ID、用户ID、标题、描述、视频URL、缩略图URL、状态、时长、标签、创建时间和更新时间等字段
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videos implements Serializable {
    @TableId
    private Integer videoId;
    private Integer userId;
    private String title;
    private String description;
    private String videoUrl;
    private String thumbnailUrl;
    private String status; // "public" or "private"
    private Integer duration; // Duration in seconds
    private String tags; // Tags separated by commas
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Serial
    private static final long serialVersionUID = 1L;
}
