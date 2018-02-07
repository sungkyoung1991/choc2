package com.sample.choc2.service.user;


import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.User;



public interface UserService {
	
	
	public User getUser(String userId) throws Exception;

	public void createUser(User user);

	public String idCheck(String userId) throws Exception;

	public String nickCheck(String nickName) throws Exception;

	public void createCosmetic(CosmeticVO cosmetic) throws Exception;

	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception;

	public int totalCount(SearchCriteria sci) throws Exception;

	public CosmeticVO getCosmetic(int cosmetic_no) throws Exception;
	
}