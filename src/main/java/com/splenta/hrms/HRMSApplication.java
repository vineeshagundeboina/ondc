package com.splenta.hrms;

import java.util.Date;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.reactive.function.client.WebClient;

import com.splenta.hrms.service.masters.EodService;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EntityScan
@EnableScheduling
@OpenAPIDefinition(servers = {@Server(url = "/hrms/", description = "Default Server URL")})
public class HRMSApplication {

	@Autowired
	private EodService eodService;

	public static void main(String[] args) {
		SpringApplication.run(HRMSApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public ITemplateResolver thymeleafTemplateResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setPrefix("mail-templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML");
//		templateResolver.setCharacterEncoding("UTF-8");
//		return templateResolver;
//	}

	@Bean
	WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}

	/// Enable for monrinng info update
	// second ,min, hour ,dayof the month,month,day of week,
	// @Scheduled(cron = "*/54 */20 */25 * * *")
	@Scheduled(cron = "0 20 09 * * *")
	public void updateMorning() {
		System.out.println("hello  " + new Date());
		eodService.updateMorning();
		System.out.println("job done " + new Date());
	}
	
	@Scheduled(cron = "0 50 18 * * *")
	public void eodNotify() {
		System.out.println("hello  " + new Date());
		eodService.eodNotify();
		System.out.println("job done " + new Date());
	}

//	/// Enable for monrinng info update
//	// second ,min, hour ,dayof the month,month,day of week,
//	// @Scheduled(cron = "*/54 */20 */25 * * *")
//	@Scheduled(cron = "0 20 09 * * *")
//	public void leaveUpdateToManager() {
//		System.out.println("hello  " + new Date());
//		eodService.leaveUpdateToManager();
//		System.out.println("job done " + new Date());
//
//	}
}
