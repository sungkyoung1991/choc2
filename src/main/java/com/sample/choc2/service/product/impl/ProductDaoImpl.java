package com.sample.choc2.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ProductVO;
import com.sample.choc2.service.product.ProductDao;


@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	public List<ProductVO> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}
	
	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

}
