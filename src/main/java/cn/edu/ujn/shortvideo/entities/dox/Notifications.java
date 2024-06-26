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
 * @TableName notifications
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notifications implements Serializable {
    @TableId
    private Integer notificationId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Integer referenceId;

    /**
     * 
     */
    private Integer read;

    /**
     * 
     */
    private LocalDateTime createdAt;

    private static final long serialVersionUID = 1L;
}