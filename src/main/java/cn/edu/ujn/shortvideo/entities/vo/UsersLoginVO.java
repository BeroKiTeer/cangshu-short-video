package cn.edu.ujn.shortvideo.entities.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName users
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersLoginVO implements Serializable {
    @TableId
    private Integer userId;
    private String username;
    private String role;
    /**
     * jwt令牌
     */
    private String token;


}