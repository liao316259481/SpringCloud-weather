package top.liaochanglei.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liaochanglei.www.service.CityClient;

/**
 * Created by lcl on 2018/6/7.
 */
@RestController
public class CityController {
	
	@Autowired
	private CityClient cityClient;

	@GetMapping("/cities")
	public String listCity(){
		//通过feign客户端查找
		return cityClient.listCity();
	}

}
