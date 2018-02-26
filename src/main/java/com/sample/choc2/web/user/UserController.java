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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.UserVO;
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
	public String login(@ModelAttribute("user") UserVO user , HttpSession session ) throws Exception{
		
		System.out.println("/user/login : POST");
		//Business Logic
		UserVO dbUser=userService.getUser(user.getUserId());
		
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
	public String createUserp(UserVO uservo, Model model){
		
		model.addAttribute("fuser", uservo);
		logger.info(""+uservo);
		return "user/createUser";
	}//회원가입 폼으로 이동
	
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public @ResponseBody Map<String,String> idCheck(@ModelAttribute("user") UserVO user) throws Exception{
		String result =userService.idCheck(user.getUserId());
		//logger.info(""+ userService.idCheck(user.getUserId()));
		//logger.info(result);
		Map<String,String> map = new HashMap<String,String>();
		if(result==null) {
			map.put("result", "사용가능한 아이디입니다");
		}else {
			map.put("result", "존재하는 아이디입니다. 다른아이디를 사용해주세요! ");
		}
		return map;
	}//아이디 중복체크
	
	@RequestMapping(value="nickCheck", method=RequestMethod.GET)
	public @ResponseBody Map<String,String> nickCheck(@ModelAttribute("user") UserVO user) throws Exception{
		String result = userService.nickCheck(user.getNickName());
		logger.info(result);
		Map<String,String> map = new HashMap<String,String>();
		if(result==null) {
			map.put("result", "사용가능한 닉네임입니다");
		}else {
			map.put("result", "존재하는 닉네임입니다. 다른닉네임를 사용해주세요! ");
		}
		return map;
	}//닉네임 중복체크
	
	@RequestMapping(value="createUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserVO user) throws Exception{
		
		logger.info(user.toString());
		userService.createUser(user);
		
		return "user/createCosmetic";
		
	}//회원가입 처리
	
	@RequestMapping(value="getMypage", method=RequestMethod.GET)
	public String getMypage(UserVO user,Model model) throws Exception {
		model.addAttribute("mypage",userService.getUser(user.getUserId()));
		return "user/getMypage";
	}//마이페이지 이동
	
	
}