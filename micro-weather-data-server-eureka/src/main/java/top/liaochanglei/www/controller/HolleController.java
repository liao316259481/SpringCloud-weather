package top.liaochanglei.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lcl on 2018/5/18.
 */
@RestController
public class HolleController {
	
	@GetMapping("/")
	public String Holle(){
		return "Holle Wolrd";
	}
}
