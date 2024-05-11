package cn.edu.ujn.shortvideo.entities;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName user_activity_logs
 */
@Data
public class UserActivityLogs implements Serializable {
    /**
     * 
     */
    private Integer log_id;

    /**
     * 
     */
    private Integer user_id;

    /**
     * 
     */
    private String activity_type;

    /**
     * 
     */
    private String ip_address;

    /**
     * 
     */
    private String device_info;

    /**
     * 
     */
    private LocalDateTime created_at;

    private static final long serialVersionUID = 1L;
}