package com.example.demo.firstjobapp.job.service;

import java.util.List;

import com.example.demo.firstjobapp.pojos.Job;

public interface JobService {
	
	List<Job> findAllJobs();
	
	void createJob(Job jobInputValue);
	
	Job getJobById(Long id);
	
	Boolean deleteJob(Long id);
	
	Job updateJob(Long id, Job updatedJob);

}
