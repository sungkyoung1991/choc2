package com.sample.choc2.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.common.Page;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.main.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;
	

	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	

	public MainController() {
		super();
	}
	

}
