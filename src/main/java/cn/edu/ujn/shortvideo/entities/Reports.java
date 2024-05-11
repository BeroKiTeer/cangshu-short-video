package cn.edu.ujn.shortvideo.entities;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName reports
 */
@Data
public class Reports implements Serializable {
    /**
     * 
     */
    private Integer report_id;

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
    private String reason;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private LocalDateTime created_at;

    @Serial
    private static final long serialVersionUID = 1L;
}