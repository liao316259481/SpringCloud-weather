package top.liaochanglei.www.service;


import top.liaochanglei.www.vo.Weather;

/**
 * Created by lcl on 2018/5/19.
 */
public interface WeatherReportService {
	
	Weather getDataByCityId (String cityId);
}
