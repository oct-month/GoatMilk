package cn.ablocker.GoatMilkPowder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CorsConfig extends WebMvcConfigurationSupport
{
	@Override
	protected void addCorsMappings(CorsRegistry registry)
	{
		super.addCorsMappings(registry);
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:8080/")
				.allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
				.allowCredentials(true)
				.maxAge(3600);
	}
}
