package com.axelor.contact.web;

import java.util.Arrays;
import java.util.List;

import com.axelor.contact.db.Country;
import com.axelor.contact.repository.CountryRepository;
import com.axelor.contact.service.CountryService;
import com.google.inject.Inject;

public class CountryController {

	@Inject
	private CountryService countryService;

	@Inject
	private CountryRepository companyRepository;

	public List<Country> getListOfCountries(String name) {
		System.err.println("CAll get Array List from string");
		System.out.println(name);
		List<String> listOfCountries = Arrays.asList(name.split("\\s*,\\s*"));
		List<Country> listOfCounries = companyRepository.all().filter("self.name in :listOfCountries")
				.bind("listOfCountries", listOfCountries).fetch();
		System.out.println("listOfCounries::" + listOfCounries.size());
		System.err.println(" Coutry id::" + listOfCounries.get(0).getId());
		System.err.println(" Coutry name::" + listOfCounries.get(0).getName());
		System.out.println("Code::" + listOfCounries.get(0).getCode());

		return listOfCounries;
	}

}
