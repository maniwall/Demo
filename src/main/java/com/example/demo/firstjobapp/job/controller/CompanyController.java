package com.example.demo.firstjobapp.job.controller;

import java.util.List;

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

import com.example.demo.firstjobapp.job.service.CompanyServiceInterface;
import com.example.demo.firstjobapp.pojos.Company;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyServiceInterface companyServiceInterface;

	public CompanyController(CompanyServiceInterface companyServiceInterface) {
		super();
		this.companyServiceInterface = companyServiceInterface;
	}

	@GetMapping
	public ResponseEntity<List<Company>> getCompanies() {
		return new ResponseEntity<List<Company>>(companyServiceInterface.getCompanies(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		companyServiceInterface.addCompany(company);
		return new ResponseEntity<String>("Company saved successfully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable Long id) {
		return new ResponseEntity<Company>(companyServiceInterface.getCompany(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {

		boolean isCompanyUpdated = companyServiceInterface.updateCompany(id, updatedCompany);

		if (isCompanyUpdated) {
			return new ResponseEntity<String>("Company Updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Company not found", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

		boolean isCompanyDeleted = companyServiceInterface.deleteCompany(id);

		if (isCompanyDeleted) {
			return new ResponseEntity<String>("Company Deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Company not found to Delete", HttpStatus.NOT_FOUND);
		}
	}
}
