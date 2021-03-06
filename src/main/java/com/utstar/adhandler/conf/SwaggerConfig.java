package com.utstar.adhandler.conf;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "config", name = "swagger-ui-open", havingValue = "true")
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        //headers默认都加入token
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("token")
                .description("认证token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.utstar.adhandler.controller"))
                .build()
                .apiInfo(metaData())
                .globalOperationParameters(parameters);
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("广告位管理")
                .description("\"Spring Boot REST API for Online Store\"")
                .version("1.0.0")
                .contact(new Contact("jenkenies", "", "jenkenies@163.com"))
                .build();
    }
}