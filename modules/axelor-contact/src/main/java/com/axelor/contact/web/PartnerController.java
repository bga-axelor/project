package com.axelor.contact.web;

import com.axelor.contact.db.Partner;
import com.axelor.contact.service.PartnerService;
import com.google.inject.Inject;

public class PartnerController {

	@Inject
	private PartnerService partnerService;

	public Partner findByEmail(String email) {
		return partnerService.findByEmail(email);
	}
}
