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
 * @TableName admin_logs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminLogs implements Serializable {
    @TableId
    private Integer log_id;

    private Integer admin_id;

    private String action;

    private LocalDateTime timestamp;

    @Serial
    private static final long serialVersionUID = 1L;
}