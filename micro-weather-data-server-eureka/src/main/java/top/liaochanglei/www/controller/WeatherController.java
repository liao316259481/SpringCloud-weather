package top.liaochanglei.www.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liaochanglei.www.service.WeatherDateService;
import top.liaochanglei.www.vo.WeatherResponse;

/**
 * Created by yvdedu.com on 2018/5/18.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherDateService weatherDateService;
	
	
	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable String cityId){
		return weatherDateService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable String cityName){
		return weatherDateService.getDataByCityName(cityName);
	}
	
}
