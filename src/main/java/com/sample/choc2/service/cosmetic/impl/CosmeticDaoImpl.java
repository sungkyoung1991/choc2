package com.sample.choc2.service.cosmetic.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.cosmetic.CosmeticDao;
import com.sample.choc2.service.domain.CosmeticVO;
import com.sample.choc2.service.domain.DryVO;
import com.sample.choc2.service.domain.OilyVO;
import com.sample.choc2.service.domain.ToxicVO;
import com.sample.choc2.service.domain.UvraysVO;
import com.sample.choc2.service.domain.WhiteningVO;
import com.sample.choc2.service.domain.WrinkleVO;

@Repository("cosmeticDaoImpl")
public class CosmeticDaoImpl implements CosmeticDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CosmeticDaoImpl.class);
	///Field
		@Autowired
		@Qualifier("sqlSessionTemplate")
		private SqlSession sqlSession;
		public void setSqlSession(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
		}
	
		public CosmeticDaoImpl() {
			System.out.println(this.getClass());
		}


	@Override
	public void createCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("CosmeticMapper.createCosmetic", cosmetic);
	}

	@Override
	public List<CosmeticVO> getCosmeticList(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getCosmeticList",cri);
	}

	@Override
	public int totalCountCosmetic(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.totalCountCosmetic",cri);
	}

	@Override
	public CosmeticVO getCosmetic(Integer cosmeticNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.getCosmetic",cosmeticNo);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		logger.error(cosmetic.toString());
		sqlSession.update("CosmeticMapper.updateCosmetic",cosmetic);
		
	}

	@Override
	public void deleteCosmetic(Integer cosmeticNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("CosmeticMapper.deleteCosmetic", cosmeticNo);
	}

	@Override
	public String getIngredientList(int cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.getIngredientList",cosmetic_no);
	}

	@Override
	public List<ToxicVO> getToxicList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getToxicList");
	}

	@Override
	public List<UvraysVO> getUvraysIngredientList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getUvraysIngredientList");
	}

	@Override
	public List<WhiteningVO> getWhiteningIngredeintList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getWhiteningIngredeintList");
	}

	@Override
	public List<WrinkleVO> getWrinkleIngredientList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getWrinkleIngredientList");
	}

	@Override
	public List<OilyVO> getOilyIngredient() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getOilyIngredient");
	}

	@Override
	public List<DryVO> getDryIngredient() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getDryIngredient");
	}

	@Override
	public List<DryVO> getSensitiveIngredient() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CosmeticMapper.getSensitiveIngredient");
	}
	
}
