package com.example.demo.firstjobapp.job.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.firstjobapp.job.repo.JobRepository;
import com.example.demo.firstjobapp.pojos.Job;

@Service
public class JobServiceImpl implements JobService {

	private JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job jobInputValue) {
		jobRepository.save(jobInputValue);
	}

	@Override
	public Job getJobById(Long id) {
		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()) {
			return job.get();
		}
		return new Job();
	}

	@Override
	public Boolean deleteJob(Long id) {
		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()) {
			jobRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Job updateJob(Long id, Job updatedJob) {
		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()) {
			Job currentJob = job.get();
			currentJob.setDescription(updatedJob.getDescription());
			currentJob.setLocation(updatedJob.getLocation());
			currentJob.setMaxSalary(updatedJob.getMaxSalary());
			currentJob.setMinSalary(updatedJob.getMinSalary());
			currentJob.setTitle(updatedJob.getTitle());
			
			jobRepository.save(updatedJob);
			return updatedJob;
		}
		return new Job();
	}

}
