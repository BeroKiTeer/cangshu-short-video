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
 * @TableName user_settings
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSettings implements Serializable {
    @TableId
    private Integer settingId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String privacy;

    /**
     * 
     */
    private Integer notifications;

    /**
     * 
     */
    private String theme;

    /**
     * 
     */
    private String language;

    /**
     * 
     */
    private LocalDateTime createdAt;

    /**
     * 
     */
    private LocalDateTime updatedAt;

    private static final long serialVersionUID = 1L;
}