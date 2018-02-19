package com.sample.choc2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.service.domain.UserVO;
import com.sample.choc2.service.main.MainDao;

@Repository("mainDaoImpl")
public class MainDaoImpl implements MainDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	SqlSession sqlSession;

	public MainDaoImpl() {
		super();
	}

	@Override
	public Map<String, Object> mainModule() {

		Map<String, Object> mainModuleList = new HashMap<String, Object>();

		List<UserVO> mainUserList = sqlSession.selectList("UserMapper.");


		mainModuleList.put("mainUserList", mainUserList);

		return mainModuleList;
	}

}
