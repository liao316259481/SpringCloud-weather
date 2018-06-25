package top.liaochanglei.www.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import top.liaochanglei.www.service.WeatherDateService;
import top.liaochanglei.www.vo.WeatherResponse;

import java.io.IOException;

/**
 * Created by lcl on 2018/5/18.
 */
@Service
public class WeatherDateServiceImpl implements WeatherDateService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherDateServiceImpl.class);
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
 
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public WeatherResponse getDataByCityId (String cityId) {
		String uri  = WEATHER_URI+"citykey=" + cityId;
		return this.doGetWeather(uri);
	}
	
	@Override
	public WeatherResponse getDataByCityName (String cityName) {
		String uri  = WEATHER_URI+"city=" + cityName;
		return this.doGetWeather(uri);
	}
	
	private WeatherResponse doGetWeather(String uri){
		
		String key = uri;
		WeatherResponse resp = null;
		String strBody = null;
		ValueOperations<String, String> opsValue = stringRedisTemplate.opsForValue();
		ObjectMapper objectMapper = new ObjectMapper();
		//增加redis  先查缓存
		if(stringRedisTemplate.hasKey(key)){
			logger.info("Redis hsa Data...");
			strBody = opsValue.get(key);
		}else {
			logger.info("Redis don't  hsa Data...");
			//增加redis没有数据   抛出异常
			throw new RuntimeException("没有数据");
		}
		try {
			resp = objectMapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			//e.printStackTrace();
			logger.error("ERROR",e);
		}
		return resp;
	}
}
