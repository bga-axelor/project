package com.axelor.contact.service;

import com.axelor.contact.db.Company;

public interface CompanyService {

	String isExistOrg(String orgName);

	Company findByName(String companyName);

}
