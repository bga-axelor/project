package com.axelor.contact.web;

import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class TestController {

	public void test(String orgName) {
		System.out.println("Orgname::" + orgName);
	}

	public void test(ActionRequest request, ActionResponse response) {
//		 organization = request.getContext().asType(Organization.class);
//		System.out.println(organization.getOrgName());
//
//		System.out.println("Request..");
//		System.out.println(request.getAction());
//		System.out.println(request.getCriteria());
//		System.out.println(request.getContext());
//		System.out.println(request.getFields());
//		System.out.println("call test method..in controller..!");
//		response.setFlash("test from testcontroller.."); //info
//		response.setAlert("test from testcontroller..");
	}

}
