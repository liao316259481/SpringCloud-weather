package top.liaochanglei.www.serviceImpl;

import ch.qos.logback.core.joran.spi.XMLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import top.liaochanglei.www.service.CityDataService;
import top.liaochanglei.www.util.XmlBuilder;
import top.liaochanglei.www.vo.City;
import top.liaochanglei.www.vo.CityRoot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcl on 2018/5/19.
 */
@Service
public class CityDataServiceImpl implements CityDataService {
	
	private static final Logger logger = LoggerFactory.getLogger(CityDataServiceImpl.class);
	
	private static final Long TIME_OUT = 1800L;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Override
	public List<City> listCity () throws Exception {
		String strXml = "";
		ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
		
		if(stringRedisTemplate.hasKey("stringStringValueOperations")){
			logger.info("读取City缓存数据成功");
			strXml = stringStringValueOperations.get("stringStringValueOperations");
		}else{
			String uri = "http://mobile.weather.com.cn/js/citylist.xml";
			
			//读取xml文件
//		Resource resource = new ClassPathResource("citylist.xml");
//		BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
//		StringBuffer sb = new StringBuffer();
//		String line = "";
//		while ((line = bf.readLine())!=null)
//			sb.append(line);
//		bf.close();
			
			logger.info("读取City数据成功");
			//通过Url
			
			ResponseEntity<String> strEntity = restTemplate.getForEntity(uri, String.class);
			if(strEntity.getStatusCodeValue()==200)
				strXml = strEntity.getBody();
			logger.info("City数据=="+strXml);
			logger.info("将City数据存入缓存中。。。");
			stringStringValueOperations.set("stringStringValueOperations",strXml,TIME_OUT, TimeUnit.SECONDS);
		}
		//xml转为java对象
		CityRoot cityList = (CityRoot) XmlBuilder.xmlStrToObject(CityRoot.class,strXml);
		return cityList.getCityList().getCitys();
	}
}
