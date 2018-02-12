package com.sample.choc2.web.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sample.choc2.common.Page;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ProductVO;
import com.sample.choc2.service.product.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	
	
	@RequestMapping("listProduct")
	public String getProductList(@ModelAttribute("search") Search search, @ModelAttribute("page") Page page, Model model)
			throws Exception {

		System.out.println("/listProduct");
		
		System.out.println("현재페이지 설정..." + search.getCurrentPage());

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		System.out.println("search 확인...." + search);

		Map<String, Object> map = productService.getProductList(search);
		
		System.out.println("map확인.........." + map);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		
		System.out.println("page확인....." + page);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);


		return "main/main";
	}
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("productVO") ProductVO productVO, Model model)
			throws Exception {

		System.out.println("/addProduct");
		
		System.out.println("productVO 확인........." + productVO);
		
		productService.addProduct(productVO);
	
		model.addAttribute("product", productVO);
		return "main/addProduct";
		
	}
	
	@RequestMapping(value = "addProductView", method = RequestMethod.GET)
	public String addProductView(@ModelAttribute("product") ProductVO productVO)
			throws Exception {

		System.out.println("/addProductView");
	
		return "main/addProductView";
		
	}

}
