package top.liaochanglei.www.service;

/**
 * Created by lcl on 2018/5/19.
 */
public interface WeatherDataCollectionService {
	
	/**
	 * g根据城市id访问
	 * @param cityId
	 */
	void sysncDataByCityId (String cityId);
}
