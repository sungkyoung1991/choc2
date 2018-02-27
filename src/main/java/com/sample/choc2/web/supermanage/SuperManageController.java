package com.sample.choc2.web.supermanage;

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
import com.sample.choc2.service.domain.UserVO;
import com.sample.choc2.service.user.UserService;

@Controller
@RequestMapping("/super")
public class SuperManageController {
	
	private static Logger logger = LoggerFactory.getLogger(SuperManageController.class);
	public SuperManageController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// =======================================UserManage Controller========================================================
	//화면조회 리스
	@RequestMapping(value="/userManage/list",method=RequestMethod.GET)
	public String listUser(Model model,@ModelAttribute("cri") SearchCriteria cri)throws Exception{
		
		model.addAttribute("list", userService.getUserList(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(userService.totalCountUser(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "superManage/getUserManageList";
	}
	//화면 상세 조회 
	@RequestMapping(value="/userManage/get",method=RequestMethod.GET)
	public String getUser(@ModelAttribute("cri") SearchCriteria cri,Model model,@RequestParam("userNo")int userNo)throws Exception{
		
		model.addAttribute(userService.getSuperUser(userNo));
		return "superManage/getUserManage";
	}
	//정보 수정 화면 
	@RequestMapping(value="/userManage/update",method=RequestMethod.GET)
	public String updateUser(@ModelAttribute("cri") SearchCriteria cri,Model model,@RequestParam("userNo")Integer userNo)throws Exception{
		

		model.addAttribute(userService.getSuperUser(userNo));
		
		return "superManage/updateUserManage";
	}
	//정보 수정 처리 
	@RequestMapping(value="/userManage/update",method=RequestMethod.POST)
	public String updateUser(Model model,UserVO userVO,
			SearchCriteria cri,RedirectAttributes rttr)throws Exception{
		
		userService.updateUser(userVO);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/super/userManage/list";
	}
	//정보 삭제  처리 
	@RequestMapping(value="/userManage/delete",method=RequestMethod.POST)
	public String deleteUser(@RequestParam("userNo")int userNo,
			SearchCriteria cri,Model model,RedirectAttributes rttr)throws Exception{
		
		userService.deleteUser(userNo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/super/userManage/list";
	}
	
}
