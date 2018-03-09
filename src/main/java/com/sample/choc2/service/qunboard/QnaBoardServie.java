package com.sample.choc2.service.qunboard;

import java.util.Map;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.QnaBoardVO;

public interface QnaBoardServie {
	public void createQnaBoard(QnaBoardVO qnaBoardVO)throws Exception;
	
	public Map<String, Object> getQnaBoardList(Search search)throws Exception;
}
