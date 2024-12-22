package com.splenta.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.splenta.hrms.filter.JwtRequestFilter;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	JdbcUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/auth/authenticate", "/api/auth/posauthenticate", "/api/auth/signup",
						"/api/auth/verifyotp", "/api/auth/sendotp", "/api/auth/resendotp/**", "/api/auth/sendpdf",
						"/api/notifications/test", "/api/auth/signupByMobile", "/api/auth/customer",
						"/api/auth/refreshtoken", "/api/product-category/uploadTest", "/api/auth/verifyemail",
						"/api/auth/resendVerifyEmail", "/api/maillist/add", "/api/auth/verifyCustomerOTP",
						"/api/auth/resetPassword", "/api/auth/savePassword", "/", "/v3/api-docs", "/v3/api-docs/*",
						"/api/order/confirm/**",
						"/api/delivery/updateOrderStatusAndNotify",
						"/swagger-ui.html", "/swagger-ui/**", "/api/static/**", "/js/**", "/webjars/**", "/uploads/**",
						"/api/partners/create", "/api/order/getOrderByDocumentNo/**", "/api/order/byStore/{storeID}",
						"/api/setting/getUpiUrl*", "/api/setting/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
