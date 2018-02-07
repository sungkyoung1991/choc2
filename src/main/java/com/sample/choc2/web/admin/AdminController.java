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
	private AdminService service;

	public void setService(AdminService service) {
		this.service = service;
	}

	// ===========================================Board=====================================================
	// 게시판 등록 화면
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public String createBoard(BoardVO vo, Model model) throws Exception {
		logger.info("regist get...");

		return "board/createBoard";
	}

	// 게시판 등록 처리
	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public String createBoard(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ........");
		logger.info(board.toString());

		service.create(board);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/admin/board/list";

	}

	// 리스트 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String listBoard(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("list get....");

		model.addAttribute("list", service.list(cri));

		PageMaker pageMaker = new PageMaker();

		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.totalCount(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "board/getBoardList";
	}

	// 게시판 조회
	@RequestMapping(value = "/board/get", method = RequestMethod.GET)
	public String getBaord(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		service.updateViewCnt(bno);
		model.addAttribute(service.get(bno));
		return "board/getBoard";
	}

	// 게시판 수정 화면
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String updateBoard(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		model.addAttribute(service.get(bno));
		return "board/updateBoard";
	}

	// 게시판 수정처리
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updateBoard(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info(rttr.toString());
		service.update(board);

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

		service.delete(bno);

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
			@RequestParam("cosmetic_no") Integer cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(service.getCosmetic(cosmetic_no));

		return "adminCosmetic/getCosmetic";
	}
	//게시물 리스트 조회 
	@RequestMapping(value = "/cosmetic/list", method = RequestMethod.GET)
	public String getCosmeticList(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmetic_no") Integer cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		service.getCosmetic(cosmetic_no);

		return "adminCosmetic/getCosmeticList";
	}
	//게시물 등록 화면 
	@RequestMapping(value = "/cosmetic/create", method = RequestMethod.GET)
	public String createCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmetic_no") Integer cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic register get...");
		
		return "adminCosmetic/getCosmetic";
	}
	//게시물 등록 처리 
	@RequestMapping(value = "/cosmetic/create", method = RequestMethod.POST)
	public String createCosmetic(CosmeticVO cosmetic, RedirectAttributes rttr) throws Exception {

		logger.info("Cosmetic register post ....");

		service.createCosmetic(cosmetic);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/admin/cosmetic/list";
	}
	//게시물 수정 화면 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.GET)
	public String updateCosmetic(@ModelAttribute("cri") SearchCriteria cri,
			@RequestParam("cosmetic_no") Integer cosmetic_no, Model model) throws Exception {

		logger.info("Cosmetic info ....");

		model.addAttribute(service.getCosmetic(cosmetic_no));

		return "adminCosmetic/updateCosmetic";
	}
	//게시물 수정 처리 
	@RequestMapping(value = "/cosmetic/update", method = RequestMethod.POST)
	public String updateCosmetic(CosmeticVO cosmetic, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info(rttr.toString());
		service.updateCosmetic(cosmetic);
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
			@RequestParam("cosmetic_no") Integer cosmetic_no, RedirectAttributes rttr) throws Exception {

		logger.info("Cosmetic info ....");

		service.deleteCosmetic(cosmetic_no);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "adminCosmetic/getCosmetic";
	}

}
