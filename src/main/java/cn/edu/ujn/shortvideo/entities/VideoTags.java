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
 * @TableName video_tags
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoTags implements Serializable {
    @TableId
    private Integer id;

    /**
     * 
     */
    private Integer video_id;

    /**
     * 
     */
    private Integer tag_id;

    /**
     * 
     */
    private LocalDateTime created_at;

    @Serial
    private static final long serialVersionUID = 1L;
}