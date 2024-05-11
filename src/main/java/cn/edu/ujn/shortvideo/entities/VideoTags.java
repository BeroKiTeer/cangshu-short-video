package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName video_tags
 */
@Data
public class VideoTags implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer video_id;

    /**
     * 
     */
    private Integer tag_id;

    /**
     * 
     */
    private LocalDateTime created_at;

    @Serial
    private static final long serialVersionUID = 1L;
}