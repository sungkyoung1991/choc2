package com.sample.choc2.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.common.Search;
import com.sample.choc2.service.domain.ProductVO;
import com.sample.choc2.service.product.ProductDao;
import com.sample.choc2.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;

	@Override
	public Map<String, Object> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				List<ProductVO> list = productDao.getProductList(search);
				
				int totalCount = productDao.getTotalCount(search);

				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", list);
				map.put("totalCount", totalCount);

				return map;
				
	}

	@Override
	public void addProduct(ProductVO product) throws Exception {
		// TODO Auto-generated method stub
		productDao.addProduct(product);
		
	}

}
