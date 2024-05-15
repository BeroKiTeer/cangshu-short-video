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
 * @TableName ads
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ads implements Serializable {
    @TableId
    private Integer adId;

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
    private String imageUrl;

    /**
     * 
     */
    private LocalDateTime startDate;

    /**
     * 
     */
    private LocalDateTime endDate;

    /**
     * 
     */
    private LocalDateTime createdAt;

    /**
     * 
     */
    private LocalDateTime updatedAt;

    @Serial
    private static final long serialVersionUID = 1L;
}