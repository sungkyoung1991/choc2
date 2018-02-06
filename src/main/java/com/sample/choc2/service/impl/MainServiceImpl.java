package com.sample.choc2.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.service.main.MainDao;
import com.sample.choc2.service.main.MainService;

@Service("mainServiceImpl")
public class MainServiceImpl implements MainService {

	@Autowired
	@Qualifier("mainDaoImpl")
	private MainDao mainDao;

	public Map<String, Object> mainModule() throws Exception {
		Map<String, Object> mainModule = new HashMap<String, Object>();

		mainModule = mainDao.mainModule();

		return mainModule;
	}

}
