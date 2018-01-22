package com.sample.choc2.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.choc2.service.domain.User;
import com.sample.choc2.service.user.UserService;

@RestController
@RequestMapping("/userRest/*")
public class UserRestController {
	
	
	//field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	public UserRestController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	
	@RequestMapping(value="json/getUser", method=RequestMethod.POST)
	public User getUser(@RequestParam("userId")String userId)throws Exception{
		
		System.out.println("/userRest/json/getUser : GET");
		
		return userService.getUser(userId);
		
	}
	
	
	//안드로이드
	@RequestMapping(value="json/login", method=RequestMethod.POST)
	public User login(@RequestBody User user, HttpSession session)throws Exception{
	
		System.out.println("/userRest/json/login : POST");
		
		User dbUser=userService.getUser(user.getUserId());
		if(user.getPassword().equals(dbUser.getPassword())) {
	     session.setAttribute("user", user);
		}
		
		return dbUser;
	
	}
	
	
	//안드로이드	
	@RequestMapping(value="json/logout", method=RequestMethod.GET)
	public void logout(HttpSession session)throws Exception{
		System.out.println("/userRest/json/logout : GET");
		
		session.invalidate();
	
	}

	
}
