package com.lancaiwu.cloud.usercenterservice.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-18
 * Time: 17:19
 * Description: springboot 版本如果是2.0以上则需要添加 ServletRegistrationBean
 */
@Configuration
public class HystrixConfig {

    /**
     * springboot 版本如果是2.0以上则需要添加 ServletRegistrationBean
     * 因为springboot的默认路径不是 "/hystrix.stream"
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<Servlet> getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
