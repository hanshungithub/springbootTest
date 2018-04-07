package cn.hassan.webcrud.config;


import cn.hassan.webcrud.component.LanuageResolver;
import cn.hassan.webcrud.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfigs extends WebMvcConfigurerAdapter {

    //所有的WebMvcConfigurerAdapter都会一起起作用
    @Bean //将组建注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            //资源映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //添加拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    //添加国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new LanuageResolver();
    }


}
