package com.example.demo.firstjobapp.job.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.firstjobapp.job.service.JobService;
import com.example.demo.firstjobapp.pojos.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

	private JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> findAll() {
		return new ResponseEntity<>(jobService.findAllJobs(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createJobs(@RequestBody Job jobInputValue) {
		jobService.createJob(jobInputValue);
		return new ResponseEntity<>("job created successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id) {

		Job currentJob = jobService.getJobById(id);

		if (!currentJob.equals(null)) {
			return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
		}
		return new ResponseEntity<Job>(currentJob, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> deleteJobById(@PathVariable Long id) {

		if (jobService.deleteJob(id)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}

		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {

		Job currentJob = jobService.updateJob(id, updatedJob);

		if (!currentJob.equals(null)) {
			return new ResponseEntity<Job>(currentJob, HttpStatus.OK);
		}
		
		return new ResponseEntity<Job>(currentJob, HttpStatus.NOT_FOUND);
	}
}
