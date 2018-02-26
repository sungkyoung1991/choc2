package com.sample.choc2.service.user;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.UserVO;

public interface UserDao {

	// SELECT ONE
	public UserVO getUser(String userId) throws Exception ;

	public void createUser(UserVO user) throws Exception;

	public String idCheck(String userId) throws Exception;

	public String nickCheck(String nickName) throws Exception;
	
	public List<UserVO> getUserList()throws Exception;

	public UserVO getSuperUser(Integer userNo)throws Exception;
}