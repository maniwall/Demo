package com.example.demo.firstjobapp.job.service;

import java.util.List;

import com.example.demo.firstjobapp.pojos.Company;

public interface CompanyServiceInterface {

	List<Company> getCompanies();

	void addCompany(Company company);

	Company getCompany(Long id);

	boolean updateCompany(Long id, Company updatedCompany);
	
	boolean deleteCompany(Long id);
}
