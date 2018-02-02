package com.sample.choc2.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.choc2.service.domain.User;
import com.sample.choc2.service.user.UserService;


@Controller
@RequestMapping("/user/*")
public class UserController {
	
	///Field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
		
	public UserController(){
		System.out.println(this.getClass());
	}
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping( value="login", method=RequestMethod.POST )
	public String login(@ModelAttribute("user") User user , HttpSession session ) throws Exception{
		
		System.out.println("/user/login : POST");
		//Business Logic
		User dbUser=userService.getUser(user.getUserId());
		
		if( user.getPassword().equals(dbUser.getPassword())){
			session.setAttribute("user", dbUser);
		}
		
		return "user/index";
	}//로그인 처리
		
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "user/index";
		
	}//로그아웃 처리
	
	@RequestMapping(value="createUserP", method=RequestMethod.GET)
	public String createUserp(){
		
		return "user/createUser";
	}//회원가입 폼으로 이동
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public @ResponseBody Map<String,String> idCheck(@ModelAttribute("user") User user) throws Exception{
	
		String result = userService.idCheck(user.getUserId());
		Map<String,String> map = new HashMap<String,String>();
		if(result==null) {
			map.put("result", "사용가능한 아이디입니다.");
		}else {
			map.put("result", "존재하는 아이디입니다. 다른아이디를 사용해주세요! ");
		}
		return map;
	}//아이디 중복체크
	
	@RequestMapping(value="nickCheck", method=RequestMethod.GET)
	public @ResponseBody Map<String,String> nickCheck(@ModelAttribute("user") User user) throws Exception{
		logger.info(""+userService.nickCheck(user.getNickName()));
		System.out.println("test");
		String result = userService.nickCheck(user.getNickName());
		Map<String,String> map = new HashMap<String,String>();
		if(result==null) {
			map.put("result", "사용가능한 닉네임입니다.");
		}else {
			map.put("result", "존재하는 닉네임입니다. 다른닉네임를 사용해주세요! ");
		}
		return map;
	}//닉네임 중복체크
	
	@RequestMapping(value="createUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user) throws Exception{
		System.out.println("/user/createUser");
		userService.createUser(user);
		return "";
		
	}//회원가입 처리

	
}