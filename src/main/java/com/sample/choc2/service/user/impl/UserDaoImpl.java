package com.sample.choc2.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.UserVO;
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


	public UserVO getUser(String userId) throws Exception {
		return sqlSession.selectOne("UserMapper.getUser", userId);
	}

	@Override
	public void createUser(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("UserMapper.createUser",user);
	}

	@Override
	public String idCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.idCheck", userId);
	}

	@Override
	public String nickCheck(String nickname) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.nickCheck",nickname);
	}

	@Override
	public List<UserVO> getUserList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("UserMapper.getUserList",cri);
	}

	@Override
	public UserVO getSuperUser(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.getSuperUser",userNo);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("UserMapper.updateUser",userVO);
	}

	@Override
	public void deleteUser(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("UserMapper.deleteUser",userNo);
	}

	@Override
	public int totalCountUser(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("UserMapper.totalCountUser",cri);
	}

	
}