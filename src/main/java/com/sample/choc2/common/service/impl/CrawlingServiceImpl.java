package com.sample.choc2.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.domain.CrawlingVO;
import com.sample.choc2.common.service.CrawlingDao;
import com.sample.choc2.common.service.CrawlingService;
import com.sample.choc2.web.supermanage.SuperManageController;

@Service("crawlingServiceImpl")
public class CrawlingServiceImpl implements CrawlingService {
	private static Logger logger = LoggerFactory.getLogger(SuperManageController.class);
	@Autowired
	@Qualifier("crawlingDaoImpl")
	private CrawlingDao crawlingDao;
	
	public CrawlingServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	public void setCrawlingDao(CrawlingDao crawlingDao) {
		
		this.crawlingDao = crawlingDao;
	}

	@Override
	public void createOvlieCrawling(CrawlingVO crawlingVO) throws Exception {
		// TODO Auto-generated method stub
		logger.debug(crawlingVO.toString());
		crawlingDao.createOvlieCrawling(crawlingVO);
		
	}
	
	
}
