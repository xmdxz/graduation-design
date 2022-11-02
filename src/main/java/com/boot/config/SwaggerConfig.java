package com.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author YuanXin
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Date 2022/8/27 19:49
 */


@Configuration
@ConfigurationProperties(prefix = "swagger")
@EnableOpenApi
@Data
public class SwaggerConfig {

    private Boolean enable;

    private String name;

    private String personUrl;

    private String email;

    private String title;

    private String version;

    private String description;


    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        Contact contact = new Contact(name, personUrl, email);
        return new ApiInfo(
                title,
                description,
                version,
                ApiInfo.DEFAULT.getTermsOfServiceUrl(),
                contact,
                ApiInfo.DEFAULT.getLicense(),
                ApiInfo.DEFAULT.getLicenseUrl(),
                ApiInfo.DEFAULT.getVendorExtensions());
    }

}
