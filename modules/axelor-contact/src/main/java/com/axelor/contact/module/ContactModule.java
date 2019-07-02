package com.axelor.contact.module;

import com.axelor.app.AxelorModule;
import com.axelor.contact.service.CompanyService;
import com.axelor.contact.service.impl.CompanyServiceImpl;

public class ContactModule extends AxelorModule {

	@Override
	protected void configure() {
	bind(CompanyService.class).to(CompanyServiceImpl.class);
		
	}

}
