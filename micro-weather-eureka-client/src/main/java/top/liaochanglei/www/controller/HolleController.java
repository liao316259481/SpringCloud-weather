package top.liaochanglei.www.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lcl on 2018/6/11.
 */
@RestController
public class HolleController {
	@GetMapping("/")
	public String Holle(){
		return "Holle Wolrd";
	}
	
}
