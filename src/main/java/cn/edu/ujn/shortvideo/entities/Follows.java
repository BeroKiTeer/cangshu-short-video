package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName follows
 */
@Data
public class Follows implements Serializable {
    /**
     * 
     */
    private Integer follow_id;

    /**
     * 
     */
    private Integer follower_id;

    /**
     * 
     */
    private Integer followed_id;

    /**
     * 
     */
    private LocalDateTime created_at;

    @Serial
    private static final long serialVersionUID = 1L;
}