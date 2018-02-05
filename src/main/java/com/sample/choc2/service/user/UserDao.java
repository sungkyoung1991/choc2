package com.sample.choc2.service.user;

import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.User;

public interface UserDao {

	// SELECT ONE
	public User getUser(String userId) throws Exception ;

	public void createUser(User user) throws Exception;

	public String idCheck(String userId) throws Exception;

	public String nickCheck(String nickName) throws Exception;

	public void createCosmetic(CosmeticVO cosmetic) throws Exception;

	
}