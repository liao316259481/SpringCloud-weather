package top.liaochanglei.www.vo;

import top.liaochanglei.www.vo.City;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by lcl on 2018/5/19.
 */
@XmlRootElement(name="c")
@XmlAccessorType(XmlAccessType.FIELD)//通过字段访问
public class CityList {
	
	@XmlElement(name="d")
	private List<City> citys;
	
	public List<City> getCitys () {
		return citys;
	}
	
	public void setCitys (List<City> citys) {
		this.citys = citys;
	}
}
