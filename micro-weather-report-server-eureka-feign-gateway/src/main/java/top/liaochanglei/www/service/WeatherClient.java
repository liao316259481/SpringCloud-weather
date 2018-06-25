package top.liaochanglei.www.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.liaochanglei.www.vo.City;
import top.liaochanglei.www.vo.WeatherResponse;

import java.util.List;

/**
 * Created by lcl on 2018/6/7.
 *  (改成zuul 后没有使用)
 */
//@FeignClient("micro-weather-data-server-eureka")
//public interface WeatherClient {
//
//	@GetMapping("/weather/cityId/{cityId}")
//	WeatherResponse getDataByCityId (@PathVariable("cityId") String cityId);
//
//	@GetMapping("/weather/cityName/{cityName}")
//	WeatherResponse getWeatherByCityName (@PathVariable("cityName") String cityName);
//}
