package com.sample.choc2.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.Product;
import com.sample.choc2.service.domain.UserVO;
import com.sample.choc2.service.product.ProductDao;
import com.sample.choc2.service.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("productDaoImpl")
	ProductDao productDao;
	
	

	public void setProductDao(ProductDao productDao) {
		System.out.println("::" + getClass() + ".setProductDao Call...");
		this.productDao = productDao;
	}

	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public void addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		productDao.insertProduct(product);

	}

	@Override
//	public Product getProduct(int prodNo) throws Exception {
//		// TODO Auto-generated method stub
//		return productDao.findProduct(prodNo);
//	}
//	public Product getProduct(UserVO user, int prodNo) throws Exception {
	
	public Product getProduct(UserVO user, Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDao.findProduct(user,product);
	}

	@Override
	public Map<String, Object> getProductList(UserVO user, Search search) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));

		return map;
	}
	
//	public Map<String, Object> getProductList(Search search) throws Exception {
//		// TODO Auto-generated method stub
//		
//		return productDao.getProductList(search);
//	}


	@Override
	public void updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		productDao.updateProduct(product);

	}

	@Override
	public int removeProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return productDao.removeProduct(prodNo);
	}

	@Override
	public void updateReply(Product product) throws Exception {
		// TODO Auto-generated method stub
		
		productDao.updateReply(product);
		
	}

}