package cn.edu.ujn.shortvideo.entities;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName users
 */
@Data
public class Users implements Serializable {
    /**
     * 
     */
    private Integer user_id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String hashed_password;

    /**
     * 
     */
    private String bio;

    /**
     * 
     */
    private String profile_image_url;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String role;

    /**
     * 
     */
    private LocalDateTime created_at;

    /**
     * 
     */
    private LocalDateTime updated_at;

    @Serial
    private static final long serialVersionUID = 1L;
}