package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName content_reviews
 */
@Data
public class ContentReviews implements Serializable {
    /**
     * 
     */
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