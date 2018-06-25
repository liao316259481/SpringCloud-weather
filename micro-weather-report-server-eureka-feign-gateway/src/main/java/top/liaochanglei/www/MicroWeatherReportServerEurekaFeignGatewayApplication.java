package top.liaochanglei.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2 //加上注解@EnableSwagger2 表示开启Swagger
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker  //开启熔断器
public class MicroWeatherReportServerEurekaFeignGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroWeatherReportServerEurekaFeignGatewayApplication.class, args);
	}
}
