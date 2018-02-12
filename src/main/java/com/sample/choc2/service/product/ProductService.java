package com.sample.choc2.service.product;

import java.util.Map;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ProductVO;

public interface ProductService {
	
	public Map<String,Object> getProductList(Search search) throws Exception;
	
	public void addProduct(ProductVO product) throws Exception;

}
