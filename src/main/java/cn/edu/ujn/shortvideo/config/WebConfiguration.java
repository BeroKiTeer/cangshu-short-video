package cn.edu.ujn.shortvideo.config;

import cn.edu.ujn.shortvideo.interceptor.JwtTokenUserInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class WebConfiguration {

    @Resource
    JwtTokenUserInterceptor jwtTokenUserInterceptor;

    // 配置拦截器
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/api/user/**")
                .excludePathPatterns("/api/user/user/login")
                .excludePathPatterns("/api/user/shop/status");
    }
}
