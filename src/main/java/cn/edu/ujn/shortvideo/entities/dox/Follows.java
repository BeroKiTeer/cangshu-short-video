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
 * @TableName follows
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follows implements Serializable {
    @TableId
    private Integer followId;

    /**
     * 
     */
    private Integer followerId;

    /**
     * 
     */
    private Integer followedId;

    /**
     * 
     */
    private LocalDateTime createdAt;

    @Serial
    private static final long serialVersionUID = 1L;
}