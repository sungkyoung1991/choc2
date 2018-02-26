package com.sample.choc2.web.supermanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.choc2.service.user.UserService;

@Controller
@RequestMapping("/super")
public class SuperManageController {
	
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

	@RequestMapping(value="/userManage/list",method=RequestMethod.GET)
	public String listUser(Model model)throws Exception{
		
		model.addAttribute("list", userService.getUserList());
		
		return "superManage/getUserManageList";
	}
}
