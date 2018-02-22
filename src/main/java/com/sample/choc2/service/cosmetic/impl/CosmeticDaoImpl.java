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
	public CosmeticVO getCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.getCosmetic",cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		logger.error(cosmetic.toString());
		sqlSession.update("CosmeticMapper.updateCosmetic",cosmetic);
		
	}

	@Override
	public void deleteCosmetic(Integer cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("CosmeticMapper.deleteCosmetic", cosmetic_no);
	}
	
}
