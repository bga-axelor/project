package com.axelor.contact.service;

import com.axelor.contact.db.Partner;

public interface PartnerService {

	Partner findByEmail(String email);

}
