package com.sample.choc2.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.User;
import com.sample.choc2.service.user.UserDao;


@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	///Constructor
	public UserDaoImpl() {
		System.out.println(this.getClass());
	}


	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne("UserMapper.getUser", userId);
	}

	@Override
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("UserMapper.createUser",user);
	}

	@Override
	public String idCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.idCheck", userId);
	}

	@Override
	public String nickCheck(String nickName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.nickCheck",nickName);
	}

	@Override
	public void createCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("UserMapper.createCosmetic", cosmetic);
	}

	@Override
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("UserMapper.getCosmeticList",cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.totalCount",cri);
	}

	@Override
	public CosmeticVO getCosmetic(int cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.getCosmetic",cosmetic_no);
	}
	
}