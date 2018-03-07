package com.sample.choc2.web.admin;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.choc2.common.Page;
import com.sample.choc2.common.PageMaker;
import com.sample.choc2.common.Search;
import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.cosmetic.CosmeticService;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.user.UserService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	@Qualifier("cosmeticServiceImpl")
	private CosmeticService cosmeticService;
	
	public void setCosmeticService(CosmeticService cosmeticService) {
		this.cosmeticService = cosmeticService;
	}
	
	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	// ==> classpath:config/common.properties ,
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 10}")
	int pageUnit;

	@Value("#{commonProperties['pageSize']}")
	 //@Value("#{commonProperties['pageSize'] ?: 10}")
	int pageSize;
	
//	@Autowired
//	@Qualifier("userServiceImple")
//	private UserService userService;
//	
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

	// ===========================================Board Controller=====================================================
	// 게시판 등록 화면
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public String createBoard(BoardVO boardVO, Model model) throws Exception {
		logger.info("regist get...");

		return "adminBoard/createAdminBoard";
	}

	// 게시판 등록 처리
	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public String createBoard(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ........");
		logger.info(boardVO.toString());

		adminService.createBoard(boardVO);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/admin/board/list";

	}

	// 리스트 조회
	@RequestMapping("/board/list")
	public String listBoard(@ModelAttribute("search")Search search,
			@ModelAttribute("page")Page page,Model model) throws Exception {
		logger.info("list get....");
		
		/*
		 * CurrentPage 현재 페이지 번호 
		 * PageSize 데이터 수 
		 * UnitSize 네비 사이즈 
		 * 
		 * */
		System.out.println("search : "+search);
		System.out.println("page : "+page);
		PageMaker pageMaker = new PageMaker();
		
		if(search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}//처음 접속시 현재 페이지 초기화
		
		search.setPageSize(pageSize);
		pageMaker.setSearch(search);
		Map<String,Object> map = adminService.getBoardList(search);
		
		Page resultPage = new Page(search.getCurrentPage(),((Integer)map.get("totalCountBoard")).intValue(), pageUnit, pageSize);
		
		
		System.out.println("resultpage: "+resultPage);
		model.addAttribute("search",search);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("resultPage",resultPage);
		model.addAttribute("pageMaker",pageMaker);
		
		
		
		System.out.println("search : "+search);
		System.out.println("page : "+page);
		return "adminBoard/getAdminBoardList";
	}

	// 게시판 조회
	@RequestMapping(value = "/board/get", method = RequestMethod.GET)
	public String getBaord(@RequestParam("boardNo") int boardNo,@ModelAttribute("search")Search search,
			@ModelAttribute("page")Page page, Model model)
			throws Exception {
		adminService.updateViewCnt(boardNo);
		model.addAttribute(adminService.getBoard(boardNo));
		return "adminBoard/getAdminBoard";
	}

	// 게시판 수정 화면
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String updateBoard(@RequestParam("boardNo") int boardNo, @ModelAttribute("search")Search search,
			@ModelAttribute("page")Page page, Model model)
			throws Exception {
		model.addAttribute(adminService.getBoard(boardNo));
		return "adminBoard/updateAdminBoard";
	}

	// 게시판 수정처리
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updateBoard(BoardVO boardVO, Search search,Page page, RedirectAttributes rttr) throws Exception {
		logger.info(rttr.toString());
		adminService.updateBoard(boardVO);

		rttr.addAttribute("currentPage", search.getCurrentPage());
		rttr.addAttribute("searchKeyword", search.getSearchKeyword());
		rttr.addAttribute("searchCondition", search.getSearchCondition());
		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());
		return "redirect:/admin/board/list";
	}

	// 게시판 삭제 처리
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String deleteBoard(@RequestParam("boardNo") int boardNo, Search search,Page page, RedirectAttributes rttr)
			throws Exception {

		adminService.deleteBoard(boardNo);

		rttr.addAttribute("currentPage", search.getCurrentPage());
		rttr.addAttribute("searchKeyword", search.getSearchKeyword());
		rttr.addAttribute("searchCondition", search.getSearchCondition());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/board/list";
	}

	// =======================================Cosmetic Controller========================================================
	//게시물 조회 
	@RequestMapping(value = "/cosmetic/get", method = RequestMethod.GET)
	public String getCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmeticNo") int cosmeticNo, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(cosmeticService.getCosmetic(cosmeticNo));

		return "adminCosmetic/getAdminCosmetic";
	}
	//게시물 리스트 조회 
	@RequestMapping("/cosmetic/list")
	public String getCosmeticList(@ModelAttribute("search") Search search,
			@ModelAttribute("page")Page page,Model model) throws Exception {
		
		logger.info("Cosmetic List info ....");
		System.out.println("search : "+search);
		System.out.println("page : "+page);
		
		if(search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}//처음 접속시 현재 페이지 초기화
		
		search.setPageSize(pageSize);
		Map<String,Object> map = adminService.getBoardList(search);
		
		Page resultPage = new Page(search.getCurrentPage(),((Integer)map.get("totalCountBoard")).intValue(), pageUnit, pageSize);
		
		
		System.out.println("resultpage: "+resultPage);
		model.addAttribute("search",search);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("resultPage",resultPage);
		
		
		
		System.out.println("search : "+search);
		System.out.println("page : "+page);
		
		return "adminCosmetic/getAdminCosmeticList";
	}
	//게시물 등록 화면 
	@RequestMapping(value = "/cosmetic/create", method = RequestMethod.GET)
	public String createCosmetic(CosmeticVO cosmeitcVO, Model model) throws Exception {

		logger.info("Cosmetic register get...");
		
		return "adminCosmetic/createAdminCosmetic";
	}
	//게시물 등록 처리 
	@RequestMapping(value = "/cosmetic/create", method = RequestMethod.POST)
	public String createCosmetic(CosmeticVO cosmeticVO, RedirectAttributes rttr) throws Exception {

		logger.info("Cosmetic register post ....");

		cosmeticService.createCosmetic(cosmeticVO);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/admin/cosmetic/list";
	}
	//게시물 수정 화면 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.GET)
	public String updateCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmeticNo") int cosmeticNo, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(cosmeticService.getCosmetic(cosmeticNo));

		return "adminCosmetic/updateAdminCosmetic";
	}
	//게시물 수정 처리 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.POST)
	public String updateCosmetic(CosmeticVO cosmeticVO, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.error(rttr.toString());
		logger.error(cosmeticVO.toString());
		
		cosmeticService.updateCosmetic(cosmeticVO);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());
		return "redirect:/admin/cosmetic/list";
	}
	//게시물 삭제 처리 
	@RequestMapping(value = "/cosmetic/delete", method = RequestMethod.POST)
	public String deleteCosmetic(SearchCriteria cri,
			@RequestParam("cosmeticNo") int cosmeticNo, RedirectAttributes rttr) throws Exception {

		logger.info("Cosmetic info ....");

		cosmeticService.deleteCosmetic(cosmeticNo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/cosmetic/list";
	}
	

}

/*
  ===========================================Board Controller=====================================================
	// 게시판 등록 화면
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public String createBoard(BoardVO boardVO, Model model) throws Exception {
		logger.info("regist get...");

		return "adminBoard/createAdminBoard";
	}

	// 게시판 등록 처리
	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public String createBoard(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ........");
		logger.info(boardVO.toString());

		adminService.createBoard(boardVO);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/admin/board/list";

	}

	// 리스트 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String listBoard(@ModelAttribute("cri")SearchCriteria cri, Model model) throws Exception {
		logger.info("list get....");

		model.addAttribute("list", adminService.listBoard(cri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);

		pageMaker.setTotalCount(adminService.countBoard(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "adminBoard/getAdminBoardList";
	}

	// 게시판 조회
	@RequestMapping(value = "/board/get", method = RequestMethod.GET)
	public String getBaord(@RequestParam("boardNo") int boardNo, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		adminService.updateViewCnt(boardNo);
		model.addAttribute(adminService.getBoard(boardNo));
		return "adminBoard/getAdminBoard";
	}

	// 게시판 수정 화면
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String updateBoard(@RequestParam("boardNo") int boardNo, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(adminService.getBoard(boardNo));
		return "adminBoard/updateAdminBoard";
	}

	// 게시판 수정처리
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updateBoard(BoardVO boardVO, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(rttr.toString());
		adminService.updateBoard(boardVO);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());
		return "redirect:/admin/board/list";
	}

	// 게시판 삭제 처리
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String deleteBoard(@RequestParam("boardNo") int boardNo, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		adminService.deleteBoard(boardNo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/board/list";
	}
	
	*/
