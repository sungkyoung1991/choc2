package com.sample.choc2.service.cosmetic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.cosmetic.CosmeticDao;
import com.sample.choc2.service.cosmetic.CosmeticService;
import com.sample.choc2.service.domain.CosmeticVO;

@Service("cosmeticServiceImpl")
public class CosmeticServiceImpl implements CosmeticService {

	@Autowired
	@Qualifier("cosmeticDaoImpl")
	private CosmeticDao cosmeticDao;

	public void setCosmeticDao(CosmeticDao cosmeticDao) {
		this.cosmeticDao = cosmeticDao;
	}

	public CosmeticServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void createCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		cosmeticDao.createCosmetic(cosmetic);
	}

	@Override
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return cosmeticDao.getCosmeticList(cri);
	}

	@Override
	public int totalCountCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return cosmeticDao.totalCountCosmetic(cri);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmeticNo) throws Exception {
		// TODO Auto-generated method stub
		return cosmeticDao.getCosmetic(cosmeticNo);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		cosmeticDao.updateCosmetic(cosmetic);
	}

	@Override
	public void deleteCosmetic(Integer cosmeticNo) throws Exception {
		// TODO Auto-generated method stub
		cosmeticDao.deleteCosmetic(cosmeticNo);
	}

}
