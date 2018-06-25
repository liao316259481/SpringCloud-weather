package top.liaochanglei.www.service;


import org.springframework.stereotype.Service;
import top.liaochanglei.www.vo.WeatherResponse;

/**
 *  data service
 * 天气 数据请求
 * Created by lcl on 2018/5/18.
 */

public interface WeatherDateService {
	
	WeatherResponse getDataByCityId(String cityId);
	
	WeatherResponse getDataByCityName(String cityName);
	
}
