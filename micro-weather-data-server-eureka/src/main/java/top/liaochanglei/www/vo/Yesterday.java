package top.liaochanglei.www.vo;

import java.io.Serializable;

/**
 * 作日天气
 * Created by yvdedu.com on 2018/5/18.
 */
public class Yesterday implements Serializable{
	private static final long serialVersionUID = -1389796650716258227L;
	//	        	 "date": "17日星期四",
//				 "high": "高温 32℃",
//				 "fx": "无持续风向",
//				 "low": "低温 26℃",
//				 "fl": "<![CDATA[<3级]]>",
//				 "type": "多云"
	private String date;
	private String high;
	private String fx;
	private String low;
	private String fl;
	private String type;
	
	public String getDate () {
		return date;
	}
	
	public void setDate (String date) {
		this.date = date;
	}
	
	public String getHigh () {
		return high;
	}
	
	public void setHigh (String high) {
		this.high = high;
	}
	
	public String getFx () {
		return fx;
	}
	
	public void setFx (String fx) {
		this.fx = fx;
	}
	
	public String getLow () {
		return low;
	}
	
	public void setLow (String low) {
		this.low = low;
	}
	
	public String getFl () {
		return fl;
	}
	
	public void setFl (String fl) {
		this.fl = fl;
	}
	
	public String getType () {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
}
