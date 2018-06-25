package top.liaochanglei.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherEurekaClientApplication.class, args);
	}
}
