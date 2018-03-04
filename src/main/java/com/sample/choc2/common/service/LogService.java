package com.sample.choc2.common.service;

import java.util.List;

import com.sample.choc2.common.domain.Log;
import com.sample.choc2.service.domain.UserVO;

public interface LogService {
	

	public List<Log> getLogList(UserVO user);
	
	public void addLog(Log log);

}
