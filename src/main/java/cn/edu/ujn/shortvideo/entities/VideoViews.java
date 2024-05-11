package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName video_views
 */
@Data
public class VideoViews implements Serializable {
    private Integer view_id;

    /**
     * 
     */
    private Integer video_id;

    /**
     * 
     */
    private Integer user_id;

    /**
     * 
     */
    private LocalDateTime watched_at;

    @Serial
    private static final long serialVersionUID = 1L;
}