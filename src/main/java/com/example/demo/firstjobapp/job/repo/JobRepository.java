package com.example.demo.firstjobapp.job.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.firstjobapp.pojos.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
