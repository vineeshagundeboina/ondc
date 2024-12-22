package com.fedcorp.admin.config;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class SecurityConfig implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//		System.out.println("this url is calling first-----> default");
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.setHeader("Content-Security-Policy"," https://10.199.14.73:9443 https://am.federalbank.co.in; object-src 'self' https://10.199.14.73:9443 https://am.federalbank.co.in ");

		httpResponse.setHeader("X-Content-Type-Options", "nosniff");

		httpResponse.setHeader("X-Frame-Options", "SAMEORIGIN");

		httpResponse.setHeader("X-XSS-Protection", "1; mode=block");

		httpResponse.setHeader("Cache-Control", "no-store");

		chain.doFilter(request, response); /* Let request continue chain filter */

	}

	@Override

	public void init(FilterConfig config) throws ServletException {

	}

}