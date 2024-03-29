package com.axelor.contact.repository;

import java.util.Map;

import com.axelor.contact.db.Partner;
import com.axelor.contact.db.repo.AbstractPartnerRepository;

public class PartnerRepository extends AbstractPartnerRepository {

	  @Override
	  public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context) {
	    if (!context.containsKey("json-enhance")) {
	      return json;
	    }
	    try {
	      Long id = (Long) json.get("id");
	      Partner partner = find(id);
	      json.put("address", partner.getAddresses().get(0));
	      json.put("hasImage", partner.getImage() != null);
	    } catch (Exception e) {
	    }

	    return json;
	  }
	

}
