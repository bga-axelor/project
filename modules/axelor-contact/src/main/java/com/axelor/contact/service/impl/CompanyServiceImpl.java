package com.axelor.contact.service.impl;

import java.util.List;

import com.axelor.contact.db.Company;
import com.axelor.contact.db.repo.CompanyRepository;
import com.axelor.contact.service.CompanyService;
import com.google.inject.Inject;

public class CompanyServiceImpl implements CompanyService {

	@Inject
	private CompanyRepository companyRepository;

	@Override
	public String isExistOrg(String orgName) {
		System.out.println("call is exist organization..");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company findByName(String name) {
		Company company = companyRepository.findByName(name);
		if (company != null) {
			return company;
		} else {
			System.err.println("Company not found..");
			return new Company();
		}
	}

}
