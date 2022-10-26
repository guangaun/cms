package com.briup.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2  //开启swagger功能
@Configuration  //配置类
public class Swagger2Config {
	
	//配置需要扫描的Controller的包路径 将使用web层注解 自动生成到文档中作为接口信息
	@Bean  //创建对应的bean对象，实现swagger功能
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.briup.cms.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	//swagger界面中显示的基本信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("swagger在线API")
				.description("欢迎访问briup官网，http://www.briup.com")
				.termsOfServiceUrl("http://www.briup.com")
				.version("1.0")
				.build();
	}
}
