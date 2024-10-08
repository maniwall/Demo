package com.example.demo.firstjobapp.job.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.firstjobapp.pojos.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> getReviewsByCompanyId(Long companyId);

}
