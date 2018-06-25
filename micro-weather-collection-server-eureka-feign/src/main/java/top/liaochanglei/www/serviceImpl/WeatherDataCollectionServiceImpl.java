package top.liaochanglei.www.serviceImpl;

import top.liaochanglei.www.service.WeatherDataCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by lcl on 2018/5/19.
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);
	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private static final Long TIME_OUT = 1800L;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public void sysncDataByCityId (String cityId) {
		String uri  = WEATHER_URI+"citykey=" + cityId;
		logger.info("同步数据中：cityId:"+cityId);
		this.saveWeatherData( uri);
	}
	
	
	/**
	 * 将天气数据存入缓存中
	 */
	private void saveWeatherData(String uri){
//		logger.info("同步数据开始");
		String key = uri;
		String strBody = null;
		ValueOperations<String, String> opsValue = stringRedisTemplate.opsForValue();
		//URI 获取数据;
		ResponseEntity<String> restString = restTemplate.getForEntity(uri, String.class);
		logger.info("获取数据中：restString:"+restString);
		if (restString.getStatusCodeValue() == 200) {
			strBody = restString.getBody();
		}
		logger.info("同步数据中：url:"+uri);
		logger.info("同步数据中：正写入redis...");
		//数据写入缓存
		opsValue.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
		
	}
}
