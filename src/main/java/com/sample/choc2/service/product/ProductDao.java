package com.sample.choc2.service.product;

import java.util.List;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ProductVO;

public interface ProductDao {
	
	public List<ProductVO> getProductList(Search search) throws Exception;
	
	public int getTotalCount(Search search) throws Exception ;

}
