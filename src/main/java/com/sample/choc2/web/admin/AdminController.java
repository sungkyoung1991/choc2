package com.sample.choc2.web.admin;

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
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.domain.BoardVO;
import com.sample.choc2.service.domain.CosmeticVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

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
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String listBoard(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
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
	public String getBaord(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		adminService.updateViewCnt(bno);
		model.addAttribute(adminService.getBoard(bno));
		return "adminBoard/getAdminBoard";
	}

	// 게시판 수정 화면
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String updateBoard(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(adminService.getBoard(bno));
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
	public String deleteBoard(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		adminService.deleteBoard(bno);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/board/list";
	}

	// =======================================Cosmetic Controller========================================================
	//게시물 조회 
	@RequestMapping(value = "/cosmetic/get", method = RequestMethod.GET)
	public String getCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmetic_no") int cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(adminService.getCosmetic(cosmetic_no));

		return "adminCosmetic/getAdminCosmetic";
	}
	//게시물 리스트 조회 
	@RequestMapping(value = "/cosmetic/list", method = RequestMethod.GET)
	public String getCosmeticList(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("Cosmetic List info ....");
		model.addAttribute("list",adminService.listCosmetic(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(adminService.countCosmetic(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
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

		adminService.createCosmetic(cosmeticVO);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/admin/cosmetic/list";
	}
	//게시물 수정 화면 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.GET)
	public String updateCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmetic_no") int cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(adminService.getCosmetic(cosmetic_no));

		return "adminCosmetic/updateAdminCosmetic";
	}
	//게시물 수정 처리 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.POST)
	public String updateCosmetic(CosmeticVO cosmeticVO, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info(rttr.toString());
		adminService.updateCosmetic(cosmeticVO);
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
			@RequestParam("cosmetic_no") int cosmetic_no, RedirectAttributes rttr) throws Exception {

		logger.info("Cosmetic info ....");

		adminService.deleteCosmetic(cosmetic_no);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/cosmetic/list";
	}

}
