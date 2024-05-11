package cn.edu.ujn.shortvideo.entities;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName ads
 */
@Data
public class Ads implements Serializable {
    /**
     * 
     */
    private Integer ad_id;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private String image_url;

    /**
     * 
     */
    private LocalDateTime start_date;

    /**
     * 
     */
    private LocalDateTime end_date;

    /**
     * 
     */
    private LocalDateTime created_at;

    /**
     * 
     */
    private LocalDateTime updated_at;

    @Serial
    private static final long serialVersionUID = 1L;
}