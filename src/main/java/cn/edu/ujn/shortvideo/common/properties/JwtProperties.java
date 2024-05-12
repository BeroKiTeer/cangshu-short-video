package cn.edu.ujn.shortvideo.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 生成jwt令牌相关配置
 */
@Component
@ConfigurationProperties(prefix = "cn.edu.ujn.jwt")
@Data
public class JwtProperties {

    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    private String userSecretKey;
    private long userTtl;
    private String userTokenName;
}
