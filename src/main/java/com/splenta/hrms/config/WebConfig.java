package com.splenta.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Component
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	PrivilegeInterceptor privilegeInterceptor;

	@Value("${file.static-locations}")
	private String staticLocations;

	@Value("${file.static-url-path}")
	private String staticUrlPath;

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(privilegeInterceptor).excludePathPatterns("/v3/api-docs", "/v3/api-docs/*",
				"/swagger-ui.html", "/swagger-ui/**", "/api/static/**", "/api/auth/sendpdf", "/js/**", "/webjars/**",
				"/api/order/confirm/**",
				"/uploads/**", "/api/order/getOrderByDocumentNo/**", "/api/order/delivery/**",
				"/api/order/byStore/{storeID}/", "/api/setting/getUpiUrl*");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(staticUrlPath + "**").addResourceLocations(staticLocations);
	}
}
