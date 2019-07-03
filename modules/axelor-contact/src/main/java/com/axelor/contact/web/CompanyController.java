package com.axelor.contact.web;

import com.axelor.contact.db.Company;
import com.axelor.contact.service.CompanyService;
import com.google.inject.Inject;

public class CompanyController {

	@Inject
	private CompanyService companyService;

	public boolean isExistOrg(String orgName) {
		System.out.println("Org name::" + orgName);
		String orgNameFromdb = companyService.isExistOrg(orgName);
		if (orgName.equalsIgnoreCase(orgNameFromdb)) {
			return true;
		}
		return false;
	}

	public Company findByName(String companyName) {
		if (companyName != null) {
			return companyService.findByName(companyName);
		}
		return null;
	}

}
