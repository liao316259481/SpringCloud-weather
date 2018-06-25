package top.liaochanglei.www.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.liaochanglei.www.service.DataClient;
import top.liaochanglei.www.service.WeatherReportService;
import top.liaochanglei.www.vo.Weather;

/**
 * Created by lcl on 2018/5/19.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	
//	@Autowired
//	private WeatherClient weatherClient;  //改成zuul提供数据
	
	@Autowired
	private DataClient dataClient;
 
	@Override
	@Cacheable(cacheNames="book1", key="#cityId")
	public Weather getDataByCityId (String cityId) {
		
		//TODO 由天气数据微服务提供
		Weather weather = dataClient.getDataByCityId(cityId).getData();
		return weather;
	}
}
