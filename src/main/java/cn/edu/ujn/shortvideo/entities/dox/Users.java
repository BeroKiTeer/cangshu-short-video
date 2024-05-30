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
 * @TableName users
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements Serializable {
    @TableId
    private Integer userId;

    private String username;

    private String email;

    private Integer sex;

    private String hashedPassword;

    private String bio;

    private String profileImageUrl;

    private String status;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Serial
    private static final long serialVersionUID = 1L;
}