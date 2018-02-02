package com.sample.choc2.service.user;


import com.sample.choc2.service.domain.User;



public interface UserService {
	
	
	public User getUser(String userId) throws Exception;

	public void createUser(User user);

	public String idCheck(String userId) throws Exception;
	
	
	
}