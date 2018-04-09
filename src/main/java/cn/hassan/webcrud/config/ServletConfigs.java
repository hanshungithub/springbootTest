package cn.hassan.webcrud.config;

import cn.hassan.webcrud.filter.FilterSettings;
import cn.hassan.webcrud.listener.ListenerSettings;
import cn.hassan.webcrud.servlet.ServletSettings;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ServletConfigs {

    //注册servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletSettings(),"/userServlet");
    }

    //注册filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterSettings());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/userServlet"));
        return registrationBean;
    }

    //注册listener
    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean<ListenerSettings> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new ListenerSettings());
        return servletListenerRegistrationBean;
    }

    //制定自定化的容器(如果代码注册需要打开，放到spring容器中)
    //@Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }
}
