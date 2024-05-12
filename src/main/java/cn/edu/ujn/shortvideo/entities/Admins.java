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
 * @TableName admins
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admins implements Serializable {
    @TableId
    private Integer admin_id;

    private String username;

    private String email;

    private String hashed_password;

    private String role;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @Serial
    private static final long serialVersionUID = 1L;
}