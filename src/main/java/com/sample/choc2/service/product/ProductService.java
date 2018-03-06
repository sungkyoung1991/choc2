package com.sample.choc2.service.product;

import java.util.Map;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.Product;

public interface ProductService {
	
	public void addProduct(Product product) throws Exception;
	
	public Product getProduct(int prodNo) throws Exception;
	
	public Map<String,Object> getProductList(Search search) throws Exception;
	
	public void updateProduct(Product product) throws Exception;
	
	public int removeProduct(int prodNo) throws Exception;
	
	public void updateReply(Product product) throws Exception;

	
	
	

}
