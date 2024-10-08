package com.example.demo.firstjobapp.job.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.firstjobapp.job.service.ReviewService;
import com.example.demo.firstjobapp.pojos.Review;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping()
	public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId) {
		return new ResponseEntity<>(reviewService.getReviews(companyId), HttpStatus.OK);
	}

	@PostMapping("/reviews")
	public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody List<Review> reviews) {
		reviewService.createReview(reviews);
		return new ResponseEntity<String>("Created Reviews successfully", HttpStatus.CREATED);
	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewbyId(@PathVariable Long reviewId) {
		return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.OK);
	}

	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReviewbyId(@PathVariable Long reviewId, @RequestBody Review updatedReview) {

		if (reviewService.updateReview(reviewId, updatedReview)) {
			return new ResponseEntity<>("Updated Reviews successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Created Reviews successfully", HttpStatus.NOT_FOUND);
		}
	}

}
