package top.liaochanglei.www.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.liaochanglei.www.vo.City;
import top.liaochanglei.www.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * zuul 网关 获取
 * Created by lcl on 2018/6/7.
 */
@FeignClient(value = "micro-weather-eureka-client-zuul",fallback=DataClientFallBack.class)
public interface DataClient {
	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity () throws Exception;
	
	/**
	 * 根据城市id获取天气
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
	
	/**
	 * 根据城市名称获取天气
	 * @param cityName
	 * @return
	 */
	@GetMapping("/data/weather/cityName/{cityName}")
	WeatherResponse getDataByCityName (@PathVariable("cityName") String cityName);
	
	
	
}
