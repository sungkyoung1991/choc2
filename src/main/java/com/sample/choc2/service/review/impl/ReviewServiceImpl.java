package com.sample.choc2.service.review.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.choc2.service.domain.ReviewVO;
import com.sample.choc2.service.review.ReviewDao;
import com.sample.choc2.service.review.ReviewService;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	@Qualifier("reviewDaoImpl")
	private ReviewDao reviewDao;
	
	public void setReviewdao(ReviewDao reviewdao) {
		this.reviewDao = reviewdao;
	}

	@Override
	public void createReview(ReviewVO review) throws Exception {
		// TODO Auto-generated method stub
		reviewDao.createReview(review);
	}

}
