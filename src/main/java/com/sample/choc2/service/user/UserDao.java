package com.sample.choc2.service.user;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.UserVO;

public interface UserDao {

	// SELECT ONE
	public UserVO getUser(String userId) throws Exception ;

	public void createUser(UserVO user) throws Exception;

	public String idCheck(String userId) throws Exception;

	public String nickCheck(String nickname) throws Exception;
	
	public List<UserVO> getUserList(SearchCriteria cri)throws Exception;

	public UserVO getSuperUser(Integer userNo)throws Exception;
	
	public void updateUser(UserVO userVO)throws Exception;
	
	public void deleteUser(Integer userNo)throws Exception;
	
	public int totalCountUser(SearchCriteria cri)throws Exception;

}