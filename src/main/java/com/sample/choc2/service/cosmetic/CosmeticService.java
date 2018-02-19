package com.sample.choc2.service.cosmetic;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;

public interface CosmeticService {
	
	public void createCosmetic(CosmeticVO cosmetic) throws Exception;

	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception;

	public int totalCount(SearchCriteria sci) throws Exception;

	public CosmeticVO getCosmetic(int cosmetic_no) throws Exception;

	public void updateCosmetic(CosmeticVO cosmetic) throws Exception;

	public void deleteCosmetic(int cosmetic_no) throws Exception;
	
	
}
