package com.sample.choc2.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.UserVO;
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
	public UserVO getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
	}

	@Override
	public void createUser(UserVO user) {
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
	public String nickCheck(String nickname) throws Exception {
		// TODO Auto-generated method stub
		return userDao.nickCheck(nickname);
	}

	@Override
	public List<UserVO> getUserList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserList(cri);
	}

	@Override
	public UserVO getSuperUser(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getSuperUser(userNo);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateUser(userVO);
	}

	@Override
	public void deleteUser(Integer userNo) throws Exception {
		// TODO Auto-generated method stub
		userDao.deleteUser(userNo);
	}

	@Override
	public int totalCountUser(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return userDao.totalCountUser(cri);
	}




	
}
