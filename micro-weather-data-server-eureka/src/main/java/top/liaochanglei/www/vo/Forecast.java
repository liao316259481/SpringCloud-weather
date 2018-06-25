package top.liaochanglei.www.vo;

import java.io.Serializable;

/**
 * 未来天气
 * Created by yvdedu.com on 2018/5/18.
 */
public class Forecast implements Serializable{
	
	private static final long serialVersionUID = 7047997359157233151L;
	//	 "		  date": "18日星期五",
//			 "high": "高温 32℃",
//			 "fengli": "<![CDATA[<3级]]>",
//			 "low": "低温 27℃",
//			 "fengxiang": "无持续风向",
//			 "type": "多云"
	private String date;
	private String high;
	private String fengxiang;
	private String low;
	private String fengli;
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
	
	public String getFengxiang () {
		return fengxiang;
	}
	
	public void setFengxiang (String fengxiang) {
		this.fengxiang = fengxiang;
	}
	
	public String getLow () {
		return low;
	}
	
	public void setLow (String low) {
		this.low = low;
	}
	
	public String getFengli () {
		return fengli;
	}
	
	public void setFengli (String fengli) {
		this.fengli = fengli;
	}
	
	public String getType () {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
}
