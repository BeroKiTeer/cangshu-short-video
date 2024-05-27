package cn.edu.ujn.shortvideo.entities.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoDTO {
    private String title;
    private String description;
    private String status;
}
