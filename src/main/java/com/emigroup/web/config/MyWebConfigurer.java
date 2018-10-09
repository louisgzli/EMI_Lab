package com.emigroup.web.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@Configuration
public class MyWebConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//文件映射，访问images/的时候映射到
        File resourcefile = new File("src/main/resources/static");
        String projectRealPath = resourcefile.getAbsolutePath();

        registry.addResourceHandler("/images/**").addResourceLocations("file:" + projectRealPath + "/");
        super.addResourceHandlers(registry);
    }
}
