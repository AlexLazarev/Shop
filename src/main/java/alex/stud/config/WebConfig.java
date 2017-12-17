package alex.stud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "alex.stud.controller")
public class  WebConfig extends WebMvcConfigurerAdapter{


    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver marker = new FreeMarkerViewResolver();
        marker.setOrder(1); //порядок загрузки
        marker.setSuffix(".ftl");

        return marker;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer(){
        FreeMarkerConfigurer marker = new FreeMarkerConfigurer();
        marker.setTemplateLoaderPaths("/","/WEB-INF/views/");

        return marker;
    }


}
