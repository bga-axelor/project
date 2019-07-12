package com.axelor.contact.web;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.SystemProperties;

import com.opencsv.CSVWriter;

public class TestController {

  public static void main(String[] args) {

		System.out.println("System properties::" + SystemProperties.getProperty("user.home")+"/.axelor/attachments");	  
    System.out.println("Export with csv ");
    String[] items1 = {"book", "coin", "pencil"};
    String[] items2 = {"pen", "chair", "lamp"};
    String[] items3 = {"ball", "bowl", "spectacles"};
    String[] header = {"Name", "Class", "Marks"};

    List<String[]> entries = new ArrayList<String[]>();
    entries.add(items1);
    entries.add(items2);
    entries.add(items3);

    String fileName = "src/main/resources/data-export/items.csv";

    try (FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        CSVWriter writer = new CSVWriter(osw)) {
      System.out.println("File name::" + fileName);
      writer.writeNext(header);
      writer.writeAll(entries);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error msg::" + e.getMessage());
    }
  }
}
