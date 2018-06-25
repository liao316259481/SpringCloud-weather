package top.liaochanglei.www.vo;

import top.liaochanglei.www.vo.Forecast;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息模型
 * Created by yvdedu.com on 2018/5/18.
 *         "date": "22日星期二",
			 "high": "高温 33℃",
			 "fengli": "<![CDATA[<3级]]>",
			 "low": "低温 26℃",
			 "fengxiang": "无持续风向",
			 "type": "多云"
 */
public class Weather implements Serializable{
	
	private static final long serialVersionUID = 5894516571513920337L;
	private String City;
	private String aqi;
	private Yesterday yesterday;
	private List<Forecast> forecast;
	private String ganmao;
	private String wendu;
	
	public String getCity () {
		return City;
	}
	
	public void setCity (String city) {
		City = city;
	}
	
	public String getAqi () {
		return aqi;
	}
	
	public void setAqi (String aqi) {
		this.aqi = aqi;
	}
	
	public Yesterday getYesterday () {
		return yesterday;
	}
	
	public void setYesterday (Yesterday yesterday) {
		this.yesterday = yesterday;
	}
	
	public List<Forecast> getForecast () {
		return forecast;
	}
	
	public void setForecast (List<Forecast> forecast) {
		this.forecast = forecast;
	}
	
	public String getGanmao () {
		return ganmao;
	}
	
	public void setGanmao (String ganmao) {
		this.ganmao = ganmao;
	}
	
	public String getWendu () {
		return wendu;
	}
	
	public void setWendu (String wendu) {
		this.wendu = wendu;
	}
}
