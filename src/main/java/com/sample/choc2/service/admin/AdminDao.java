package com.sample.choc2.service.admin;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.BoardVO;

public interface AdminDao {

	public void create(BoardVO vo)throws Exception;
	
	public BoardVO get(Integer bno)throws Exception;
	
	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> list(SearchCriteria cri)throws Exception;
	
	public int totalCount(SearchCriteria cri)throws Exception;
	
}
