package top.liaochanglei.www.vo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 城市类
 * Created by lcl on 2018/5/19.
 */
@XmlRootElement(name="d")
@XmlAccessorType(XmlAccessType.FIELD)//通过字段访问
public class City{
	@XmlAttribute(name="d1")
	private String cityId;
	@XmlAttribute(name="d2")
	private String cityName;
	@XmlAttribute(name="d3")
	private String cityCode;
	@XmlAttribute(name="d4")
	private String province;
	
	public String getCityId () {
		return cityId;
	}
	
	public void setCityId (String cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName () {
		return cityName;
	}
	
	public void setCityName (String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityCode () {
		return cityCode;
	}
	
	public void setCityCode (String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getProvince () {
		return province;
	}
	
	public void setProvince (String province) {
		this.province = province;
	}
}
