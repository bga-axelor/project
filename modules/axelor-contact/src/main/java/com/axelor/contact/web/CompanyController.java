package com.axelor.contact.web;

import com.axelor.contact.service.CompanyService;
import com.google.inject.Inject;

public class CompanyController {

	@Inject
	private CompanyService organizationService;

	public boolean isExistOrg(String orgName) {
		System.out.println("Org name::" + orgName);
		String orgNameFromdb = organizationService.isExistOrg(orgName);
		if (orgName.equalsIgnoreCase(orgNameFromdb)) {
			return true;
		}
		return false;
	}

}
