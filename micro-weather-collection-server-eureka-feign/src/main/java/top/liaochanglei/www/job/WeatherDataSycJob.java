package top.liaochanglei.www.job;

import top.liaochanglei.www.service.CityClient;
import top.liaochanglei.www.service.WeatherDataCollectionService;
import top.liaochanglei.www.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
public class WeatherDataSycJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(WeatherDataSycJob.class);
	
 
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Autowired
	private CityClient cityClient;
	
	int index = 0;
	
	@Override
	protected void executeInternal (JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Syc Job Start...");
		
		//TODO 改为由城市微服务API提供数据
		List<City> cities = null;
		//获取城市id列表
		try {
			//TODO 改为由城市微服务API提供数据 (目前为模拟数据)
			cities = cityClient.listCity();
		} catch (Exception e) {
			logger.info("ERROR",e);
		}
		//遍历城市id获取天气
		cities.forEach(city->{
			if(index>20)//测试 只处理20条数据
				return;
			weatherDataCollectionService.sysncDataByCityId(city.getCityId());
			index++;
		});
		
		logger.info("Weather Data Syc Job Close...");
	}
}
