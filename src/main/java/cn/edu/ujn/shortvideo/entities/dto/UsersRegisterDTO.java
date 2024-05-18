package cn.edu.ujn.shortvideo.entities.dto;

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
public class UsersRegisterDTO implements Serializable {

    private Integer userId;

    private String username;

    private String email;

    private String password;
}