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
 * @TableName content_reviews
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentReviews implements Serializable {
    @TableId
    private Integer review_id;

    /**
     * 
     */
    private Integer video_id;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer reviewer_id;

    /**
     * 
     */
    private String notes;

    /**
     * 
     */
    private LocalDateTime reviewed_at;

    @Serial
    private static final long serialVersionUID = 1L;
}