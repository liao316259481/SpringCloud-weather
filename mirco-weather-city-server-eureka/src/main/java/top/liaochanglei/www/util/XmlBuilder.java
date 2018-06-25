package top.liaochanglei.www.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

/**
 * Created by lcl on 2018/5/19.
 */
public class XmlBuilder {
	/**
	 * 将xml转未指定对象
	 * @param tClass
	 * @param xmlStr
	 * @return
	 */
	public static Object xmlStrToObject(Class<?> tClass,String xmlStr) throws JAXBException, IOException {
		Object xmlObject  = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(tClass);
		//xml转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);//读物静态文件
//		xmlObject =unmarshaller.unmarshal(new URL("xmlStr"));//读取URl
		if(null!=reader)
			reader.close();
		return xmlObject;
	};
}
