package com.bosch.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;

/**d
 * @program: demo
 * @description:
 * @author: wjy
 * @create: 2019-06-13 14:06
 */

@Configuration
public class ConfigAdapter extends WebMvcConfigurerAdapter {
    /**
     * 添加默认主页，访问域名或者端口跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/*.html").excludePathPatterns("/login.html");
        super.addInterceptors(registry);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("128MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("256MB");
        //设置文件路径
        //factory.setLocation("");
        return factory.createMultipartConfig();
    }

}