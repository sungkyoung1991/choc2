package com.sample.choc2.service.user;

import com.sample.choc2.service.domain.User;

public interface UserDao {

	// SELECT ONE
	public User getUser(String userId) throws Exception ;

	public void createUser(User user) throws Exception;

	
}