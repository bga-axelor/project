package com.axelor.contact.web;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.axelor.app.AppSettings;
import com.axelor.contact.db.Address;
import com.axelor.contact.db.Partner;
import com.axelor.contact.repository.PartnerRepository;
import com.axelor.contact.service.PartnerService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.opencsv.CSVWriter;

public class PartnerController {

	@Inject
	private PartnerService partnerService;

	@Inject
	private PartnerRepository partnerRepository;

	public String getImageUrl(String imageMEtaFile) {
		String uploadDir = AppSettings.get().get("file.upload.dir")+"/";
		return uploadDir;
	}

	public String getIdsToString(ArrayList<String> ids) {
		System.out.println("ids");
		String str = ids.toString().substring(1, ids.toString().length() - 1);
		System.out.println("---------------------------------------");
		System.out.println(str);
		System.out.println("---------------------------------------");

		return str;
	}

	public Partner findByEmail(String email) {
		return partnerService.findByEmail(email);
	}

	public void dataExport(ActionRequest req, ActionResponse res) {

	System.out.println(req.getContext().entrySet());
		
		
		String fileName = "project/axelor/modules/axelor-contact/src/main/resources/data-export/partnerList.csv";

		String[] header = { "Title", "First Name", "Last Name", "Email", "Street", "Area", "City", "Zip", "State",
				"Country", "Company Name" };
		List<String[]> arrayList = new ArrayList<String[]>();

		arrayList.add(header);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			CSVWriter csvwriter = new CSVWriter(osw);
			System.out.println("File name::" + fileName);

			// get contactList

			List<Partner> listOfPartners = partnerRepository.all().fetch();

			System.out.println("listOfPartners::" + listOfPartners.size());
			for (Partner partner : listOfPartners) {
				List<String> list = new ArrayList<String>();
				List<String> listOfAddress = new ArrayList<String>();
				list.add(partner.getTitle());
				list.add(partner.getFirstName());
				list.add(partner.getLastName());
				list.add(partner.getEmail());

				for (Address address : partner.getAddresses()) {

					listOfAddress.add(address.getImportId());

					// listOfAddress.add(address.getStreet());
					// listOfAddress.add(address.getArea());
					// listOfAddress.add(address.getCity());
					// listOfAddress.add(address.getZip());
					// listOfAddress.add(address.getState());
					// listOfAddress.add(address.getCountry());
					//

				}
				list.addAll(listOfAddress);
				String citiesCommaSeparated = String.join(",", list);
				arrayList.add(citiesCommaSeparated.split(","));
			}

			csvwriter.writeAll(arrayList);

			csvwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error msg::" + e.getMessage());
		}
	}
}
