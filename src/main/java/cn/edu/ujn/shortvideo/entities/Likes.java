package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName likes
 */
@Data
public class Likes implements Serializable {
    /**
     * 
     */
    private Integer like_id;

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
    private LocalDateTime created_at;

    @Serial
    private static final long serialVersionUID = 1L;
}