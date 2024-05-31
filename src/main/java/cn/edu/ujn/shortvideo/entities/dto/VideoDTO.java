package cn.edu.ujn.shortvideo.entities.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VideoDTO {
    private int page; // 当前页码
    private int size; // 每页显示数量
    private Integer videoId;
    private String title;
    private String description;
    private String status;

}
