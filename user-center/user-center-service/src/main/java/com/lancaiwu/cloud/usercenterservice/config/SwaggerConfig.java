package com.lancaiwu.cloud.usercenterservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-12
 * Time: 16:51
 * Description: Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.lancaiwu.cloud.usercenterservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("用户中心Swagger")
                //创建人
                .contact(new Contact("LanCaiWu", "http://www.lancaiwu.com", "lancaiwu@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 用户中心")
                .build();
    }
}
