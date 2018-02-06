package com.sample.choc2.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.User;
import com.sample.choc2.service.user.UserDao;
import com.sample.choc2.service.user.UserService;;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	
	///Field
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	///Constructor
	public UserServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.createUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String idCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.idCheck(userId);
	}

	@Override
	public String nickCheck(String nickName) throws Exception {
		// TODO Auto-generated method stub
		return userDao.nickCheck(nickName);
	}

	@Override
	public void createCosmetic(CosmeticVO cosmetic) throws Exception{
		// TODO Auto-generated method stub
		userDao.createCosmetic(cosmetic);
	}

	@Override
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getCosmeticList(cri);
	}

	@Override
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return userDao.totalCount(cri);
	}

}
