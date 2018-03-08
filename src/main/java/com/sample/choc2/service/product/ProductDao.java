package com.sample.choc2.service.product;

import java.util.List;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.Product;

public interface ProductDao {

	public void insertProduct(Product product) throws Exception;

	public Product findProduct(int prodNo) throws Exception;
	
//	public Product findProduct(Product product) throws Exception;

	public List<Product> getProductList(Search search) throws Exception;
	

	public void updateProduct(Product product) throws Exception;

	String makeCurrentPageSql(String sql, Search search);

	int removeProduct(int prodNo) throws Exception;
	
	public int getTotalCount(Search search) throws Exception ;

	public void updateReply(Product product);
	

}
