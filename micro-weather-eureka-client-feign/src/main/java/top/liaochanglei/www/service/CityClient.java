package top.liaochanglei.www.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcl on 2018/6/7.
 */

@FeignClient("micro-weather-city-server-eureka")
public interface CityClient {
	
	@GetMapping("/cities")
	String listCity();
}
