package com.sample.choc2.web.cosmetic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.cosmetic.CosmeticService;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.web.user.UserController;

@Controller
@RequestMapping("/user/*")

public class CosmeticController {
	
	@Autowired
	@Qualifier("cosmeticServiceImpl")
	private CosmeticService cosmeticService;
	
	public CosmeticController() {
		System.out.println(this.getClass());
	}
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="createCosmeticP", method=RequestMethod.GET)
	public String createCosmeticP(){
		
		return "user/createCosmetic";
		
	}//화장품 정보입력 폼으로 이동
	
	@RequestMapping(value="createCosmetic", method=RequestMethod.POST)
	public String createCosmetic(@ModelAttribute("cosmetic") CosmeticVO cosmetic,RedirectAttributes rttr) throws Exception{
		
		cosmeticService.createCosmetic(cosmetic);
		
		rttr.addFlashAttribute("msg","success"); 
		return "redirect:/user/getCosmeticList";
		
	}//화장품 정보입력 처리
	
	@RequestMapping(value="getCosmeticList", method=RequestMethod.GET)
	public String getCosmeticList(@ModelAttribute("cri")SearchCriteria cri,Model model) throws Exception{
		
		model.addAttribute("clist",cosmeticService.getCosmeticList(cri));//searchtype,keyword
		
		logger.info(""+cosmeticService.getCosmeticList(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri); //현재페이지, 페이지안 데이터갯수
		
		pageMaker.setTotalCount(cosmeticService.totalCount(cri)); //totalCount로 네비게이션 첫,끝,pre,next 설정
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "user/getCosmeticList";
		
	}//리스트 조회(Searchcriteria, pagemaker)
	
	
	@RequestMapping(value="getCosmetic", method=RequestMethod.GET)
	public String getCosmetic(@ModelAttribute("cri")SearchCriteria cri,@RequestParam("cosmetic_no") int cosmetic_no,Model model) throws Exception{
		model.addAttribute("cinfo",cosmeticService.getCosmetic(cosmetic_no));
			
		return "user/getCosmetic";
	}//화장품 정보 상세히 보기
	
	@RequestMapping(value="updateCosmeticP", method=RequestMethod.GET)
	public String updateCosmeticP(@RequestParam("cosmetic_no") int cosmetic_no,@ModelAttribute("cri")SearchCriteria cri,Model model) throws Exception{
		
		model.addAttribute("cinfo",cosmeticService.getCosmetic(cosmetic_no));	
		
		logger.info("gg",cosmeticService.getCosmetic(cosmetic_no));
		return "user/updateCosmetic";
	}//화장품 글수정 폼으로 이동
	
	@RequestMapping(value="updateCosmetic", method=RequestMethod.POST)
	public String updateCosmetic(@ModelAttribute("cosmetic") CosmeticVO cosmetic, RedirectAttributes rttr,SearchCriteria cri ) throws Exception {
		
		
		cosmeticService.updateCosmetic(cosmetic);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/getCosmeticList";
	}//화장품 글 수정 처리
	
	@RequestMapping(value="deleteCosmetic", method=RequestMethod.GET)
	public String deleteCosmetic(@RequestParam("cosmetic_no") int cosmetic_no, RedirectAttributes rttr,SearchCriteria cri ) throws Exception {
		
		
		cosmeticService.deleteCosmetic(cosmetic_no);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/getCosmeticList";
	}//화장품 글 삭제
	
}
