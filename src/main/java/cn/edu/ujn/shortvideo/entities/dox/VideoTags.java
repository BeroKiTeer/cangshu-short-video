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
    private Integer videoId;

    /**
     * 
     */
    private Integer tagId;

    /**
     * 
     */
    private LocalDateTime createdAt;

    @Serial
    private static final long serialVersionUID = 1L;
}