package top.liaochanglei.www.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import top.liaochanglei.www.vo.City;

import java.util.List;

/**
 * Created by lcl on 2018/6/7.
 * (改成zuul 后没有使用)
 */
//@FeignClient("micro-weather-city-server-eureka")
//public interface CityClient {
//
//	@GetMapping("/cities")
//	List<City> listCity () throws Exception;
//}
