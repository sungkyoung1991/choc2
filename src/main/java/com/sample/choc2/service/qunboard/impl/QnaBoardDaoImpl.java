package com.sample.choc2.service.qunboard.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.QnaBoardVO;
import com.sample.choc2.service.qunboard.QnaBoardDao;

@Repository("qnaBoardDaoImpl")
public class QnaBoardDaoImpl implements QnaBoardDao {
	
	private static String NAMESPACE ="QnaBoardMapper";
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public QnaBoardDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void createQnaBoard(QnaBoardVO qnaBoardVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".createQnaBoard",qnaBoardVO);
	}

	@Override
	public List<QnaBoardVO> getQnaBoardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getQnaBoardList", search);
	}

	@Override
	public int totalCountQnaBoard(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".totalCountQnaBoard",search);
	}

}
