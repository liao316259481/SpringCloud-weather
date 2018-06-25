package top.liaochanglei.www.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liaochanglei.www.service.CityDataService;
import top.liaochanglei.www.vo.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcl on 2018/5/18.
 */
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	CityDataService cityDataService;
	
	@GetMapping
	public List<City> Holle() throws Exception {
		return cityDataService.listCity();
	}
}
