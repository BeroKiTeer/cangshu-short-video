package cn.edu.ujn.shortvideo.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName user_activity_logs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserActivityLogs implements Serializable {
    @TableId
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