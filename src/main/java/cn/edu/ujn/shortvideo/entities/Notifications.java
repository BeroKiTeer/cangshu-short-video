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
 * @TableName notifications
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notifications implements Serializable {
    @TableId
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