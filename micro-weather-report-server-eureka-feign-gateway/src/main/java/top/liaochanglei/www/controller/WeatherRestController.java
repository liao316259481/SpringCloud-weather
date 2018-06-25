package top.liaochanglei.www.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.liaochanglei.www.service.DataClient;
import top.liaochanglei.www.service.WeatherReportService;
import top.liaochanglei.www.vo.City;
import top.liaochanglei.www.vo.WeatherResponse;

import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
@Api(value = "weather", description = "天气管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("rest")
public class WeatherRestController {
	
	@Autowired
	WeatherReportService weatherReportService;
//	@Autowired
//	CityClient cityClient;//改成zuul提供数据
	@Autowired
	private DataClient dataClient;

	@ApiOperation(value="获取天气详细信息", notes="根据城市的名称来获取天气详细信息")
	@ApiImplicitParam(name = "cityName", value = "城市的名称", required = true, dataType = "String", paramType = "path")
	@GetMapping("/cityName/{cityName}")
	@ResponseBody
	public WeatherResponse getWeatherByCityName(@PathVariable String cityName){
		return dataClient.getDataByCityName(cityName);
	}

	@ApiOperation(value="获取天气详细信息", notes="根据城市的id来获取天气详细信息")
	@ApiImplicitParam(name = "cityId", value = "城市的id", required = true, dataType = "Integer", paramType = "path")
	@GetMapping("/cityById/{cityId}")
	@ResponseBody
	public WeatherResponse getWeatherByCityId(@PathVariable String cityId){
		return dataClient.getDataByCityId(cityId);
	}
}
