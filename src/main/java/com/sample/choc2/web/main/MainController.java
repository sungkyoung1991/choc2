package com.sample.choc2.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.service.main.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;

	public MainController() {
		super();
	}
	
	@RequestMapping(value="mainModule", method=RequestMethod.GET)
	public String index(Model model) throws Exception{
		
		model.addAttribute("mainList",mainService.mainModule());
		
		return "views/main/main.jsp";
	}
}
