package cn.iocoder.springboot.lab24.apidoc.config;

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

@Configuration
@EnableSwagger2 // 标记项目启用 Swagger API 接口文档
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi() {
        // 创建 Docket 对象
        // Docket 对象是 Swagger-Springfox 库中的一个主要接口，用于配置和自定义生成 API 文档的设置。
        // 它允许你指定 API 的基本包、要包含或排除的路径以及其他元数据（如标题、描述和版本）。
        return new Docket(DocumentationType.SWAGGER_2) // 文档类型，使用 Swagger2
                .apiInfo(this.apiInfo()) // 设置 API 信息
                // 扫描 Controller 包路径，获得 API 接口
                // .select() 启动 API 选择器构建器，用于定义哪些接口会被包含在生成的 API 文档中
                .select()
                // 指定要扫描的基本包路径，使得 Swagger 只会生成该包中的 API 接口的文档
                .apis(RequestHandlerSelectors.basePackage("cn.iocoder.springboot.lab24.apidoc.controller"))
                // 匹配所有的 URL 路径，使得 Swagger 会为所有路径生成 API 文档。
                .paths(PathSelectors.any())
                // 构建出 Docket 对象
                .build();
    }

    /**
     * 创建 API 信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试接口文档示例")
                .description("我是一段描述")
                .version("1.0.0") // 版本号
                // Contact 是 Swagger-Springfox 库中的一个类，用于在生成的 API 文档中提供联系信息。
                // 它包含了联系人姓名、网站 URL 和电子邮件地址等信息。
                .contact(new Contact("芋艿", "http://www.iocoder.cn", "zhijiantianya@gmail.com")) // 联系人
                .build();
    }

}
