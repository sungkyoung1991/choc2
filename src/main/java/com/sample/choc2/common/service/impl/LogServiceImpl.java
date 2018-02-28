package com.sample.choc2.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.domain.Log;
import com.sample.choc2.common.service.LogDao;
import com.sample.choc2.common.service.LogService;
import com.sample.choc2.service.domain.UserVO;

@Service("logServiceImpl")
public class LogServiceImpl implements LogService{
	
	@Autowired
	@Qualifier("logDaoImpl")
	private LogDao logDao;
	
	public LogServiceImpl() {
		System.out.println("Constructor :: "+getClass().getName());
	}

	@Override
	public List<Log> getLogList(UserVO user) {
		// TODO Auto-generated method stub
		return logDao.getLogList(user);
	}

	@Override
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		logDao.addLog(log);
	}
	
	
}


