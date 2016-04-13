package com.puhui.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wentong on 2016/4/12.
 * swagger 配置
 */
@Configuration
@EnableSwagger2
public class MySwaggerConfig {
//    private SpringSwaggerConfig springSwaggerConfig;
//
//    /**
//     * Required to autowire SpringSwaggerConfig
//     */
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
//
//    /**
//     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
//     * swagger groups i.e. same code base multiple swagger resource listings.
//     */
//    @Bean
//    public SwaggerSpringMvcPlugin customImplementation(){
//        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
//                .apiInfo(apiInfo())
//                .swaggerGroup("api-docs").build();
//        return swaggerSpringMvcPlugin;
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "周文童-title",
//                "周文童-description",
//                "",
//                "",
//                "",
//                "");
//    }
@Bean
public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .paths(PathSelectors.regex("/api.*"))
            .build();
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户接口文档")
                .description("用户接口文档")
                .termsOfServiceUrl("http://wiki.puhuitech.cn/pages/viewpage.action?pageId=11502024")
                .contact("zhouwentong")
                .license("puhuifinance license")
                .licenseUrl("http://wiki.puhuitech.cn")
                .version("1.0")
                .build();
    }
}
