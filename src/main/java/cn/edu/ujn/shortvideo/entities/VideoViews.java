package cn.edu.ujn.shortvideo.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName video_views
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoViews implements Serializable {
    @TableId
    private Integer viewId;

    /**
     * 
     */
    private Integer videoId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private LocalDateTime watchedAt;

    @Serial
    private static final long serialVersionUID = 1L;
}