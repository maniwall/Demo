package com.example.demo.firstjobapp.job.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.firstjobapp.job.repo.ReviewRepository;
import com.example.demo.firstjobapp.pojos.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	public List<Review> getReviews(Long companyId) {
		return reviewRepository.getReviewsByCompanyId(companyId);
	}

	public void createReview(List<Review> reviews) {
		reviewRepository.saveAll(reviews);
	}

	public Review getReviewById(Long reviewId) {

		Optional<Review> review = reviewRepository.findById(reviewId);
		if (review.isPresent()) {
			return review.get();
		} else {
			return new Review();
		}
	}

	public boolean updateReview(Long reviewId, Review updatedReview) {
		if (null != getReviewById(reviewId).getId()) {
			Review review = getReviewById(reviewId);
			/*
			 * Company company = review.getCompany(); List<Review> reviews =
			 * company.getReviews();
			 * 
			 * for(Review currentReview: reviews) {
			 * if(currentReview.getId().equals(review.getId())) {
			 * 
			 * } }
			 */

			review.setCompany(updatedReview.getCompany());
			review.setDescription(updatedReview.getDescription());
			review.setCompany(updatedReview.getCompany());
			reviewRepository.save(review);

			return true;
		} else {
			return false;
		}
	}
}
