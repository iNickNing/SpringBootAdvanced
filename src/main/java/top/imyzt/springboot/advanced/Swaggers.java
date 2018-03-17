package top.imyzt.springboot.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
/**
 * Swagger2配置类
 */
public class Swaggers {

    @Bean
    public Docket swaggerSpringMvcPlugin(){
        ApiInfo apiInfo = new ApiInfo("Spring Boot Api",
                                    "一个Spring Boot项目脚手架",
                                    "0.0.1",
                                    null,null,null,null);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false);
    }
}
