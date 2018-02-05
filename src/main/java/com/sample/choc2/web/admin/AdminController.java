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
import com.sample.choc2.service.admin.AdminSerivce;
import com.sample.choc2.service.domain.BoardVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	@Qualifier("boardServiceImpl")
	private AdminSerivce service;

	public void setService(AdminSerivce service) {
		this.service = service;
	}

	// 게시판 등록 화면
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public String createBoard(BoardVO vo, Model model) throws Exception {
		logger.info("regist get...");

		return "board/createBoard";
	}
	//게시판 등록 처리
	  @RequestMapping(value="/board/create", method = RequestMethod.POST)
		public String createBoard(BoardVO board, RedirectAttributes rttr)throws Exception {
			logger.info("regist post ........");
			logger.info(board.toString());
			
			service.create(board);
			
			rttr.addFlashAttribute("msg","success");     
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
	//게시판 수정처리 
	@RequestMapping(value="/board/update",method=RequestMethod.POST)
	public String updateBoard(BoardVO board, SearchCriteria cri, RedirectAttributes rttr)throws Exception{
		logger.info(rttr.toString());
		service.update(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg","SUCCESS");
		
		logger.info(rttr.toString());
		return "redirect:/admin/board/list";
	}
	//삭제 처리
	 @RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	  public String deleteBoard(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    service.delete(bno);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/admin/board/list";  
	  }

}
