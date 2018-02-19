package com.sample.choc2.service.cosmetic.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.SearchCriteria;
import com.sample.choc2.service.cosmetic.CosmeticDao;
import com.sample.choc2.service.domain.CosmeticVO;

@Repository("cosmeticDaoImpl")
public class CosmeticDaoImpl implements CosmeticDao {
	
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
	public int totalCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.totalCount",cri);
	}

	@Override
	public CosmeticVO getCosmetic(int cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("CosmeticMapper.getCosmetic",cosmetic_no);
	}

	@Override
	public void updateCosmetic(CosmeticVO cosmetic) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("CosmeticMapper.updateCosmetic",cosmetic);
	}

	@Override
	public void deleteCosmetic(int cosmetic_no) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("CosmeticMapper.deleteCosmetic", cosmetic_no);
	}
	
}
