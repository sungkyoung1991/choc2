package com.sample.choc2.web.crawling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.sample.choc2.common.CrawlingSearch;

@Controller
@RequestMapping("/crawling")
public class CrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);
	
//	@Autowired
//	@Qualifier("crawlingServiceImpl")
//	private CrawlingService crawlingService;
//	
//	public void setCrawlingService(CrawlingService crawlingService) {
//		this.crawlingService = crawlingService;
//	}
	
	public CrawlingController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/oliveSearch",method=RequestMethod.GET)
	public String oliveSearc(Model model) throws Exception{
	System.out.println("get임");
		
		return "crawling/oliveSearch";
	}
	
	@RequestMapping(value="/oliveSearch",method=RequestMethod.POST)
	public String oliveSearch (Model model,@RequestParam("index")String index, HttpRequestHandlerServlet request) throws Exception{
//	public String oliveSearch (Model model,@RequestBody String index) throws Exception{
		logger.info("SearchPost");
		System.out.println("index : "+index );
		CrawlingSearch clo = new CrawlingSearch();
		clo.CrawlingOlive(index);
		
		return "redirect:/crawling/oliveSearch";
	}
	

}
