package cn.edu.ujn.shortvideo.entities.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UsersDTO implements Serializable {

    private Integer userId;
    private String username;
    private String email;
    private String bio;
    private String profileImageUrl;
    private String status;
    private String role;

}