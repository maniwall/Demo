package com.example.demo.firstjobapp.job.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.firstjobapp.pojos.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
