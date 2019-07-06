package com.axelor.contact.web;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.axelor.contact.db.Address;
import com.axelor.contact.db.Partner;
import com.axelor.contact.repository.PartnerRepository;
import com.axelor.contact.service.PartnerService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;
import com.opencsv.CSVWriter;

public class PartnerController {

  @Inject private PartnerService partnerService;

  @Inject private PartnerRepository partnerRepository;

  public Partner findByEmail(String email) {
    return partnerService.findByEmail(email);
  }

  public void dataExport(ActionRequest req, ActionResponse res) {

    String fileName =
        "project/axelor/modules/axelor-contact/src/main/resources/data-export/partnerList.csv";

    String[] header = {
      "Title",
      "First Name",
      "Last Name",
      "Email",
      "Street",
      "Area",
      "City",
      "Zip",
      "State",
      "Country",
      "Company Name"
    };
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
        list.add(partner.getTitle());
        list.add(partner.getFirstName());
        list.add(partner.getLastName());
        list.add(partner.getEmail());

        for (Address address : partner.getAddresses()) {
          List<String> listOfAddress = new ArrayList<String>();
          List<String> listOfofCSVRecords = new ArrayList<String>();
          listOfAddress.add(address.getStreet());
          listOfAddress.add(address.getArea());
          listOfAddress.add(address.getCity());
          listOfAddress.add(address.getZip());
          listOfAddress.add(address.getState());
          listOfAddress.add(address.getCountry());
          listOfofCSVRecords.addAll(list);
          listOfofCSVRecords.addAll(listOfAddress);
          String citiesCommaSeparated = String.join(",", listOfofCSVRecords);
          arrayList.add(citiesCommaSeparated.split(","));
        }
      }

      csvwriter.writeAll(arrayList);

      csvwriter.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error msg::" + e.getMessage());
    }
  }
}
