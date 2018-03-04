package com.sample.choc2.service.cosmetic;

import java.util.List;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.DryVO;
import com.sample.choc2.service.domain.OilyVO;
import com.sample.choc2.service.domain.SensitiveVO;
import com.sample.choc2.service.domain.ToxicVO;
import com.sample.choc2.service.domain.UvraysVO;
import com.sample.choc2.service.domain.WhiteningVO;
import com.sample.choc2.service.domain.WrinkleVO;

public interface CosmeticService {
	
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception;

	public void createCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public CosmeticVO getCosmetic(Integer cosmeticNo)throws Exception;
	
	public void updateCosmetic(CosmeticVO cosmeticVO)throws Exception;
	
	public void deleteCosmetic(Integer cosmeticNo)throws Exception;
	
	public int totalCountCosmetic(SearchCriteria cri)throws Exception;

	public String getIngredientList(int cosmeticNo) throws Exception;

	public List<ToxicVO> getToxicList() throws Exception;

	public List<UvraysVO> getUvraysIngredientList() throws Exception;

	public List<WhiteningVO> getWhiteningIngredeintList() throws Exception;

	public List<WrinkleVO> getWrinkleIngredientList() throws Exception;

	public List<OilyVO> getOilyIngredient() throws Exception;

	public List<DryVO> getDryIngredient() throws Exception;

	public List<SensitiveVO> getSensitiveIngredient() throws Exception;
}
