/*package com.sample.choc2.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.cosmetic.CosmeticService;
import com.sample.choc2.service.main.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;
	
	@RequestMapping(value="mainModule", method=RequestMethod.GET)
	public String getProductList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
//		model.addAttribute("productList",productService.getProductList(search).get("list"));
//		
//		Page resultPage = new Page(search.getCurrentPage(), ((Integer) productService.getProductList(search).get("totalCount")).intValue(), pageUnit,
//				pageSize);
//		model.addAttribute("resultPage",resultPage);
		
		
		
		model.addAttribute("productList",cosmeticService.getCosmeticList(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(cosmeticService.totalCountCosmetic(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "main/main";
	}
}
*/