package com.lancaiwu.cloud.storecenterservice.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-04-15
 * Time: 20:54
 * Description: Druid 的配置文件
 */
@Configuration
public class DruidConfig {
    @Value("${spring.datasource.druid.stat-view-servlet.login-username}")
    private String username;
    @Value("${spring.datasource.druid.stat-view-servlet.login-password}")
    private String password;

    @Bean
    public ServletRegistrationBean druidServlet() {// 主要实现web监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");//表示进行druid监控的配置处理操作
        //servletRegistrationBean.addInitParameter("allow", "127.0.0.1,192.168.202.233");//白名单
        //servletRegistrationBean.addInitParameter("deny", "192.168.202.234");//黑名单
        servletRegistrationBean.addInitParameter("loginUsername", username);//用户名
        servletRegistrationBean.addInitParameter("loginPassword", password);//密码
        servletRegistrationBean.addInitParameter("resetEnable", "false");//是否可以重置数据源
        return servletRegistrationBean;

    }

    @Bean    //监控
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");//所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//排除
        return filterRegistrationBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
