/*package com.sample.choc2.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.service.main.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;
	
	@RequestMapping(value="mainModule", method=RequestMethod.GET)
	public String getProductList() throws Exception{
		
		System.out.println("main Module controller");
		
		return "main/main";
	}
}
*/