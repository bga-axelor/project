package com.axelor.contact.service.impl;

import com.axelor.contact.db.Partner;
import com.axelor.contact.repository.PartnerRepository;
import com.axelor.contact.service.PartnerService;
import com.google.inject.Inject;

public class PartnerServiceImpl implements PartnerService {

	@Inject
	private PartnerRepository partnerRepository;

	@Override
	public Partner findByEmail(String email) {
		System.err.println("Service impl::" + email);
		return partnerRepository.findByEmail(email);
	}

}
