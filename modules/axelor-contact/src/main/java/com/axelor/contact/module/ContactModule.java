package com.axelor.contact.module;

import com.axelor.app.AxelorModule;
import com.axelor.contact.service.CompanyService;
import com.axelor.contact.service.CountryService;
import com.axelor.contact.service.PartnerService;
import com.axelor.contact.service.impl.CompanyServiceImpl;
import com.axelor.contact.service.impl.CountryServiceImpl;
import com.axelor.contact.service.impl.PartnerServiceImpl;

public class ContactModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(CompanyService.class).to(CompanyServiceImpl.class);
//	bind(CompanyServiceImpl.class).to(CompanyRepository.class);	

		bind(CountryService.class).to(CountryServiceImpl.class);
//		bind(CountryServiceImpl.class).to(CountryRepository.class);
//		bind(CountryServiceImpl.class).to(AbstractCompanyRepository.class);
		
		bind(PartnerService.class).to(PartnerServiceImpl.class);

	}

}
