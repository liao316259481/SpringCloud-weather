package top.liaochanglei.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * Rest Configuration 配置类
 * Created by lcl on 2018/5/19.
 */
@Configuration
public class RestConfiguration {
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	public RestTemplate restTemplate(){
		return builder.build();
	}
	
}
