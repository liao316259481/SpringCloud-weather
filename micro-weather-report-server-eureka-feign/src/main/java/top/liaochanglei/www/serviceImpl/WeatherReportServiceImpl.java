package top.liaochanglei.www.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.liaochanglei.www.service.WeatherClient;
import top.liaochanglei.www.service.WeatherReportService;
import top.liaochanglei.www.vo.Forecast;
import top.liaochanglei.www.vo.Weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
	@Autowired
	private WeatherClient weatherClient;
 
	@Override
	@Cacheable(cacheNames="book1", key="#cityId")
	public Weather getDataByCityId (String cityId) {
		
		//TODO 由天气数据微服务提供
		Weather weather = weatherClient.getDataByCityId(cityId).getData();
		return weather;
	}
}
