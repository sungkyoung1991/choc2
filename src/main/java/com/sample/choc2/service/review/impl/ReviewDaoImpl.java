package com.sample.choc2.service.review.impl;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.service.domain.ReviewVO;
import com.sample.choc2.service.review.ReviewDao;

@Repository("reviewDaoImpl")
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void createReview(ReviewVO review) {
		// TODO Auto-generated method stub
		sqlSession.insert("ReviewMapper.createReview",review);
	}
	
	
	
}
