package top.liaochanglei.www.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.liaochanglei.www.vo.City;
import top.liaochanglei.www.vo.Weather;
import top.liaochanglei.www.vo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * zuul 网关 获取
 * Created by lcl on 2018/6/7.
 */
@Component
public class DataClientFallBack implements DataClient{
	
	@Override
	public List<City> listCity () throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101280301");
		city.setCityName("惠州");
		cityList.add(city);
		
		return cityList;
	}
	
	@Override
	public WeatherResponse getDataByCityId (String cityId) {
		WeatherResponse w = new WeatherResponse();
		Weather we = new Weather();
		we.setCity("eqwe");
		w.setData(we);
		return w;
	}
	
	@Override
	public WeatherResponse getDataByCityName (String cityName) {
		return null;
	}
}
