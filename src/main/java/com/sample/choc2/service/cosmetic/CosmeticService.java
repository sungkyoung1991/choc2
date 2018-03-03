package com.sample.choc2.service.cosmetic;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;

public interface CosmeticService {
	
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception;

	public void createCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public CosmeticVO getCosmetic(Integer cosmeticNo)throws Exception;
	
	public void updateCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public void deleteCosmetic(Integer cosmeticNo)throws Exception;
	
	public int totalCountCosmetic(SearchCriteria cri)throws Exception;
	
	
}
