package top.liaochanglei.www.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)//通过字段访问
public class CityRoot {
	@XmlElement(name="c")
	private CityList cityList;
	
	public CityList getCityList () {
		return cityList;
	}
	
	public void setCityList (CityList cityList) {
		this.cityList = cityList;
	}
}
