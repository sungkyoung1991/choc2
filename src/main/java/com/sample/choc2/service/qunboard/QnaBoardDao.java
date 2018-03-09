package com.sample.choc2.service.qunboard;

import java.util.List;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.QnaBoardVO;

public interface QnaBoardDao {
	public void createQnaBoard(QnaBoardVO qnaBoardVO)throws Exception;
	
	public List<QnaBoardVO> getQnaBoardList(Search search)throws Exception;
	
	public int totalCountQnaBoard(Search search)throws Exception;
	
	
}
