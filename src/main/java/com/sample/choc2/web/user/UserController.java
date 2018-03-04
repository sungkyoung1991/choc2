package com.sample.choc2.web.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.cosmetic.CosmeticService;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.DryVO;
import com.sample.choc2.service.domain.OilyVO;
import com.sample.choc2.service.domain.ToxicVO;
import com.sample.choc2.service.domain.UserVO;
import com.sample.choc2.service.domain.UvraysVO;
import com.sample.choc2.service.domain.WhiteningVO;
import com.sample.choc2.service.domain.WrinkleVO;
import com.sample.choc2.service.user.UserService;


@Controller
@RequestMapping("/user/*")
public class UserController {
	
	///Field
	@Autowired
	@Qualifier("cosmeticServiceImpl")
	private CosmeticService cosmeticService;
	
	public void setCosmeticService(CosmeticService cosmeticService) {
		this.cosmeticService = cosmeticService;
	}
	
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

	//-----------------------------Cosmetic----------------------------------
	@RequestMapping(value="createCosmeticP", method=RequestMethod.GET)
	public String createCosmeticP(){
		
		return "user/createCosmetic";
		
	}//화장품 정보입력 폼으로 이동

	@RequestMapping(value="getMypage", method=RequestMethod.GET)
	public String getMypage(UserVO user,Model model) throws Exception {
		model.addAttribute("mypage",userService.getUser(user.getUserId()));
		return "user/getMypage";
	}//마이페이지 이동
	

	
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
		
		pageMaker.setTotalCount(cosmeticService.totalCountCosmetic(cri)); //totalCount로 네비게이션 첫,끝,pre,next 설정
		
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
	
	
	@RequestMapping(value="getIngredientList", method=RequestMethod.GET)
	 public String getIngredientList(@RequestParam("cosmetic_no") int cosmetic_no,Model model) throws Exception {
		

		String ingredient = cosmeticService.getIngredientList(cosmetic_no); 
		List<String> object = Arrays.asList(ingredient.split("\\s*,\\s*"));
//		String [] object = ingredient.split("\\s*,\\s*");
		List<ToxicVO> toxicVo = cosmeticService.getToxicList();
		
//		ArrayList<String>list = new ArrayList<>();
//		for(String ingre:sArray) {
//			list.add(ingre);
//		}		
		model.addAttribute("ingreinfo",object);
		model.addAttribute("toxicinfo",toxicVo);
				
//		System.out.println("vo 확인중............"+sArray);
		logger.info("성분 리스트 "+object);
//		logger.info("성분 "+cosmeticService.getIngredientList(cosmetic_no));
		logger.info("독성 리스트"+toxicVo.toString());

		
		return "user/getIngredientList";
	}
	
	@RequestMapping(value="getFunctionalIngredientList", method=RequestMethod.GET)
	public String getFunctionalIngredientList (@RequestParam("cosmetic_no") int cosmetic_no,Model model) throws Exception {
		String ingredient = cosmeticService.getIngredientList(cosmetic_no);
		List<String> object = Arrays.asList(ingredient.split("\\s*,\\s*"));
		List<UvraysVO> uvVO = cosmeticService.getUvraysIngredientList();
		List<WhiteningVO> whiteningVO = cosmeticService.getWhiteningIngredeintList();
		List<WrinkleVO> wrinkleVO = cosmeticService.getWrinkleIngredientList();
		
		model.addAttribute("ingreinfo",object);
		model.addAttribute("uvingreinfo",uvVO);
		model.addAttribute("whiteningingreinfo",whiteningVO);
		model.addAttribute("wrinkleingreinfo",wrinkleVO);
		
		logger.info("성분 리스트 "+object);
		logger.info("자외선차단 리스트 "+uvVO);
		logger.info("미백 리스트 "+ whiteningVO);
		logger.info("주름 리스트 "+ wrinkleVO);
		
		return "user/getFunctionalIngredientList";
	}
	
	@RequestMapping(value="getSkinTypeIngredientList", method=RequestMethod.GET)
		public String getSkinTypeIngredientList(@RequestParam("cosmetic_no")int cosmetic_no,Model model) throws Exception {
		String ingredient = cosmeticService.getIngredientList(cosmetic_no);
		List<String> object = Arrays.asList(ingredient.split("\\s*,\\s*"));
		List<OilyVO> oilyVO = cosmeticService.getOilyIngredient();
		List<DryVO> dryVO = cosmeticService.getDryIngredient();
		List<DryVO> sensitiveVO = cosmeticService.getSensitiveIngredient();
		
		model.addAttribute("ingreinfo",object);
		model.addAttribute("oilyingreinfo",oilyVO);
		model.addAttribute("dryingreinfo",dryVO);
		model.addAttribute("sensitiveingreinfo",sensitiveVO);
		logger.info("성분 리스트 "+object);
		logger.info("지성 리스트 "+oilyVO);
		logger.info("건성 리스트 "+dryVO);
		logger.info("민감 리스트 "+sensitiveVO);
		
		return "user/getSkinTypeIngredientList"; 
	}
	
	
	
}