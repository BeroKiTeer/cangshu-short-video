package cn.edu.ujn.shortvideo.entities.dox;

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
 * @TableName videos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videos implements Serializable {
    @TableId
    private Integer videoId;

    /**
     * 
     */
    private Integer userId;

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
    private String videoUrl;

    /**
     * 
     */
    private String thumbnailUrl;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer duration;

    /**
     * 
     */
    private String tags;

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