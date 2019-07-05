package com.axelor.contact.service.impl;

import java.util.List;

import com.axelor.contact.db.Country;
import com.axelor.contact.repository.CountryRepository;
import com.axelor.contact.service.CountryService;
import com.google.inject.Inject;

public class CountryServiceImpl implements CountryService {

	@Inject
	private CountryRepository companyRepository;

	@Override
	public List<Country> getListOfCountries(List<String> list) {
		return companyRepository.getListOfCountries(list);
	}

}
