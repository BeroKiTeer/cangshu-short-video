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
 * @TableName likes
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Likes implements Serializable {
    @TableId
    private Integer likeId;

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
    private LocalDateTime createdAt;

    @Serial
    private static final long serialVersionUID = 1L;
}