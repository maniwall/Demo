package com.example.demo.firstjobapp.job.service;

import java.util.List;

import com.example.demo.firstjobapp.pojos.Review;

public interface ReviewService {
	
	public List<Review> getReviews(Long companyId);
	
	public void createReview(List<Review> reviews);
	
	public Review getReviewById(Long reviewId);

	public boolean updateReview(Long reviewId, Review updatedReview);
	
}
