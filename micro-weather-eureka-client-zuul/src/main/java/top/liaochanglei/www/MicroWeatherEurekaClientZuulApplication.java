package top.liaochanglei.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy //开启zuul
public class MicroWeatherEurekaClientZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherEurekaClientZuulApplication.class, args);
	}
}
