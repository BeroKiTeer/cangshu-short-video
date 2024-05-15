package cn.edu.ujn.shortvideo.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName reports
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reports implements Serializable {
    @TableId
    private Integer reportId;

    /**
     * 
     */
    private Integer videoId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String reason;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private LocalDateTime createdAt;

    @Serial
    private static final long serialVersionUID = 1L;
}