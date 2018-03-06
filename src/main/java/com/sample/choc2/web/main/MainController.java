/*package com.sample.choc2.web.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.common.Page;
import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.main.MainService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	@Qualifier("mainServiceImpl")
	private MainService mainService;
	
	@RequestMapping(value="mainModule", method=RequestMethod.GET)
	public String getProductList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("productList",productService.getProductList(search).get("list"));
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) productService.getProductList(search).get("totalCount")).intValue(), pageUnit,
				pageSize);
	model.addAttribute("resultPage",resultPage);
		
		
		
		model.addAttribute("productList",cosmeticService.getCosmeticList(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(cosmeticService.totalCountCosmetic(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "main/main";
	}
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() throws Exception{
	
		return "/main/main";
	

}//메인
	
	
	@RequestMapping(value = "getMyZzimList")
	public ModelAndView getMyZzimList(@ModelAttribute("search") Search search,
			@ModelAttribute("page") Page page) throws Exception {
		
		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);

		Zzim zzim = new Zzim();
		zzim.setUserId(user.getUserId());
		
		Map<String, Object> map = festivalService.getMyZzimList(search, user.getUserId());
		
		List<Festival> list = new ArrayList<Festival>();
		
		int listSize = ((List<Zzim>) map.get("list")).size();
		
		for(int i =0; i<listSize ; i++){
			
			System.out.println("listSize......." +  listSize);
			
			Zzim returnZzim = ((List<Zzim>) map.get("list")).get(i);
			
			Festival festival = festivalService.getFestivalDB(returnZzim.getFestivalNo());
			
			list.add(festival);
			
		}
		
		Page resultPage = new Page(search.getCurrentPage(), ((Integer) map.get("totalCount")).intValue(), pageUnit,
				pageSize);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("forward:/view/festival/getMyZzimList.jsp");
		
		modelAndView.addObject("search", search);
		modelAndView.addObject("list", list);
		modelAndView.addObject("resultPage", resultPage);
		

		return modelAndView;


	}


}
*/