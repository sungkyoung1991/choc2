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
import com.sample.choc2.service.product.ProductService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	

	public MainController() {
		super();
	}
	
	@RequestMapping(value="mainModule", method=RequestMethod.GET)
	public String getProductList(@ModelAttribute("search") Search search, @ModelAttribute("page") Page page, Model model) throws Exception{
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		model.addAttribute("productList",productService.getProductList(search).get("list"));
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) productService.getProductList(search).get("totalCount")).intValue(), pageUnit,
				pageSize);
		model.addAttribute("resultPage",resultPage);
		
		return "main/main";
	}
}
