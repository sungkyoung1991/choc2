package com.sample.choc2.service.product;

import java.util.Map;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.Product;
import com.sample.choc2.service.domain.UserVO;

public interface ProductService {
	
	public void addProduct(Product product) throws Exception;
	
//	public Product getProduct(UserVO user, int prodNo) throws Exception;
	
	public Product getProduct(UserVO user, Product product) throws Exception;
	
	public Map<String,Object> getProductList(UserVO user, Search search) throws Exception;
	
	public void updateProduct(Product product) throws Exception;
	
	public int removeProduct(int prodNo) throws Exception;
	
	public void updateReply(Product product) throws Exception;

	
	
	

}
