package cn.edu.ujn.shortvideo.entities.dox;

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
    private Integer logId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String activityType;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 
     */
    private String deviceInfo;

    /**
     * 
     */
    private LocalDateTime createdAt;

    private static final long serialVersionUID = 1L;
}