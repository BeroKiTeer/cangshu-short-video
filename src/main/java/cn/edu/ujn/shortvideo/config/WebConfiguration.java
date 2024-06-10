package cn.edu.ujn.shortvideo.config;

import cn.edu.ujn.shortvideo.common.json.JacksonObjectMapper;
import cn.edu.ujn.shortvideo.interceptor.JwtTokenUserInterceptor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@Slf4j
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Resource
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    // 配置拦截器
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/api/user/**")
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout");
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/pages/**")
                .excludePathPatterns("/pages/login/*")
                .excludePathPatterns("/pages/register/*")
                .excludePathPatterns("/pages/logout/*")
                .excludePathPatterns("/pages/index/*");
    }

    /**
     * 扩展springMVC框架的消息转换器
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建一个消息转换器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //需要为消息转换器设置一个对象转换器，对象转换器可以将Json对象序列化为Json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将自己的消息转化器加入到容器中
        converters.add(0,converter);
    }

    /**
     * 配置静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
<<<<<<< test/videos
        registry.addResourceHandler("/videos/**")
                .addResourceLocations("classpath:/static/videos/");
=======
        registry.addResourceHandler("/static/videos/**")
                .addResourceLocations("classpath:/static/");
>>>>>>> master
    }
}
