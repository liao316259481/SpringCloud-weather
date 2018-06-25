package top.liaochanglei.www.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.liaochanglei.www.service.CityClient;
import top.liaochanglei.www.service.WeatherReportService;
import top.liaochanglei.www.vo.City;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
@Controller
@RequestMapping("report")
public class WeatherReportController {
	
	@Autowired
	WeatherReportService weatherReportService;
	@Autowired
	CityClient cityClient;
 
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable String cityId, Model mode) throws Exception {
		
		//TODO  由城市微服务数据提供给 城市列表
		List<City> cities = cityClient.listCity();
		
		mode.addAttribute("titlt","测试天气预报");
		mode.addAttribute("cityId",cityId);
		mode.addAttribute("cityList",cities);
		mode.addAttribute("report",weatherReportService.getDataByCityId(cityId));
		
		ModelAndView modelAndView = new ModelAndView("weather/report","reportModel",mode);
//		modelAndView.addObject("weather",weatherReportService.getDataByCityId(cityId));
//		modelAndView.setViewName("weather/report");
		
		return modelAndView;
	}
	
//	@GetMapping("/cityName/{cityName}")
//	public WeatherResponse getWeatherByCityName(@PathVariable String cityName){
//		return weatherReportService.getDataByCityName(cityName);
//	}
}
