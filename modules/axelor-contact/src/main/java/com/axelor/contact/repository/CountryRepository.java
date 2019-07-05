package com.axelor.contact.repository;

import java.util.List;

import javax.persistence.Query;

import com.axelor.contact.db.Country;
import com.axelor.contact.db.repo.AbstractCountryRepository;
import com.axelor.db.JPA;

public class CountryRepository extends AbstractCountryRepository {

	@SuppressWarnings("unchecked")
	public List<Country> getListOfCountries(List<String> str) {
//		String query = "select e from contact_country as e where e.name in ('India','France')";
		String q1 = "select c.id,c.name from com.axelor.contact.db.Country as c where c.name in ('India','France')";
		String query = "select c.id, c.name from com.axelor.contact.db.Country as c where c.name in ('India','France')";
//		List<Country> listOfCounries = JPA.em().createQuery(query).getResultList();
//		List<Country> listOfCounries = JPA.em().createQuery(query, Country.class).getResultList();
//		
//		if (listOfCounries.size() > 0) {
		System.out.println("***********");
		/*--------------------------------------------------------------*/
		Query queryPerist = JPA.em().createQuery(q1);
		/*--------------------------------------------------------------*/
		List<Country> listOfCourCountries = (List<Country>) queryPerist.getResultList();

		System.err.println("listOfCourCountries::" + listOfCourCountries.size());
		System.out.println(listOfCourCountries.get(0).getName());
		System.out.println(listOfCourCountries.get(1));
//			for (Object obj : listOfCounries) {
//				System.out.println(obj);
//				Country country = (Country) obj;
//				System.out.println("Country name" + country.getName());
//			}
//		}
//		return listOfCounries;
		return null;
	}

}
