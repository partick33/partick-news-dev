package com.partick.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 * @author partick_peng
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    //    http://localhost:8088/swagger-ui.html     原路径
    //    http://localhost:8088/doc.html            新路径

    /**
     * 配置swagger2核心配置 docket
     * @return
     */
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("com.partick.user.controller");

        return new Docket(DocumentationType.SWAGGER_2)
                // 指定api类型为swagger2
                .apiInfo(apiInfo())
                // 用于定义api文档汇总信息
                .select()
                .apis(Predicates.or(userPredicate))
                // 所有controller
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档页标题
                .title("自媒体接口api")
                // 联系人信息
                .contact(new Contact("partick",
                        "https://www.partick.com",
                        "abc@partick.com"))
                // 详细信息
                .description("自媒体平台提供的api文档")
                // 文档版本号
                .version("1.0.1")
                // 网站地址
                .termsOfServiceUrl("https://www.partick.com")     
                .build();
    }
}
