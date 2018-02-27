package com.sample.choc2.web.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.choc2.common.Criteria;
import com.sample.choc2.common.PageMaker;
import com.sample.choc2.service.admin.AdminService;
import com.sample.choc2.service.domain.ReplyVO;
import com.sample.choc2.service.reply.ReplyService;

@RestController
@RequestMapping("/replyRest")
public class ReplyRestController {
	
	@Autowired
	@Qualifier("replyServiceImpl")
	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	public ReplyRestController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	//댓글 등록 처리 
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> createReply(@RequestBody ReplyVO replyVO)throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			replyService.createReply(replyVO);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
			return entity;
	}
	//댓글 리스트 처리 
	@RequestMapping(value="/{replyNo}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listReply(@PathVariable Integer replyNo, @PathVariable Integer page)throws Exception{
		
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> list = replyService.listReplyPage(replyNo, cri);
			
			map.put("list", list);
			
			int CountReply = replyService.countReply(replyNo);
			pageMaker.setTotalCount(CountReply);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);  
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	//댓글 수정 처리
	@RequestMapping(value="/{replyNo}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> updateReply(@PathVariable Integer replyNo,@RequestBody ReplyVO replyVO)throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			replyVO.setReplyNo(replyNo);
			replyService.updateReply(replyVO);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		
		return entity;
	}
	//댓글 삭제 처리 
	@RequestMapping(value="/{replyNo}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteeReply(@PathVariable Integer replyNo)throws Exception{
		ResponseEntity<String> entity = null;
		try {
			replyService.deleteReply(replyNo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	

}
