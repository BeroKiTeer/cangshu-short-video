package cn.edu.ujn.shortvideo.entities;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName notifications
 */
@Data
public class Notifications implements Serializable {
    /**
     * 
     */
    private Integer notification_id;

    /**
     * 
     */
    private Integer user_id;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Integer reference_id;

    /**
     * 
     */
    private Integer read;

    /**
     * 
     */
    private LocalDateTime created_at;

    private static final long serialVersionUID = 1L;
}