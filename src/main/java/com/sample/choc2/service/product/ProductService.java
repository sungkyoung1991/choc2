package com.sample.choc2.service.product;

import java.util.Map;

import com.sample.choc2.common.Search;

public interface ProductService {
	
	public Map<String,Object> getProductList(Search search) throws Exception;

}
