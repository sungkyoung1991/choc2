package com.sample.choc2.web.admin;

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

@RestController
@RequestMapping("/replyRest")
public class AdminRestController {
	
	@Autowired
	@Qualifier("adminServiceImpl")
	private AdminService service;
	
	public void setService(AdminService service) {
		this.service = service;
	}
	public AdminRestController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	//댓글 등록 처리 
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> createReply(@RequestBody ReplyVO vo)throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			service.createReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
			return entity;
	}
	//댓글 리스트 처리 
	@RequestMapping(value="/{bno}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listReply(@PathVariable Integer bno, @PathVariable Integer page)throws Exception{
		
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> list = service.listReplyPage(bno, cri);
			
			map.put("list", list);
			
			int CountReply = service.countReply(bno);
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
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> updateReply(@PathVariable Integer rno,@RequestBody ReplyVO vo)throws Exception{
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			service.updateReply(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
		
		return entity;
	}
	//댓글 삭제 처리 
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteeReply(@PathVariable Integer rno)throws Exception{
		ResponseEntity<String> entity = null;
		try {
			service.deleteReply(rno);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	
	

}
