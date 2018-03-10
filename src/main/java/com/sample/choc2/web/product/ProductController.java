package com.sample.choc2.web.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.choc2.common.Page;
import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.Product;
import com.sample.choc2.service.domain.UserVO;
import com.sample.choc2.service.product.ProductService;
import com.sample.choc2.service.reply.ReplyService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	/// Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	@Autowired
	@Qualifier("replyServiceImpl")
	private ReplyService replyService;

	public ProductController() {
		System.out.println(this.getClass());
	}

	// ==> classpath:config/common.properties ,
	@Value("#{commonProperties['pageUnit']}")
	// @Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	// @Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;



	@RequestMapping("listProduct")
	public String getProductList(
			//@ModelAttribute("user") UserVO user,
			
			@ModelAttribute("search") Search search, 
			
			@ModelAttribute("page") Page page,  Model model, HttpServletRequest request)
			throws Exception {
		
		

		System.out.println("/listProduct");
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		System.out.println("user..." + user);
		
		
		

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
	

		Map<String, Object> map = productService.getProductList(user,search);

		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);
		
		model.addAttribute("search", search);
		model.addAttribute("list", map.get("list"));
		//model.addAttribute("user", user);
		model.addAttribute("resultPage", resultPage);

		return "product/listProduct";
	}



@RequestMapping("getProduct")
public String getProduct( @RequestParam("prodNo") int prodNo, Model model, HttpServletRequest request)
		throws Exception {

	System.out.println("/getProduct");
	// Business Logic
	
//	UserVO user = this.getUser(session);
	
	HttpSession session = request.getSession();
	UserVO user = (UserVO) session.getAttribute("user");
	
	System.out.println("controller user.........." + user);
	
	Product product = new Product();
	
	product.setProductNo(prodNo);

	 product = productService.getProduct(user,product);
	
	
	System.out.println("Controller Product Check : " + product);
	
	model.addAttribute("product", product);
	
	return "product/getProduct";
}

@RequestMapping("updateProductView")
public String updateProductView(@RequestParam("prodNo") int prodNo, HttpSession session) throws Exception {
	
	System.out.println("/updateProductView");
	
	UserVO user = this.getUser(session);

//	Product product = productService.getProduct(user, prodNo);

//	ModelAndView modelAndView = new ModelAndView();
//	modelAndView.setViewName("forward:/product/updateProductView.jsp");
//	modelAndView.addObject("product", product);

	return null;
}



public UserVO getUser(HttpSession session) {
	UserVO user = new UserVO();
	if( (UserVO)session.getAttribute("user") != null ) {
		user = (UserVO)session.getAttribute("user");
	}
	return user;
}
}