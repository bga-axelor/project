package com.axelor.project.controller;

import com.axelor.project.service.ProjectService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class ProjectController {

	@Inject
	private ProjectService projectService;

	public String getPrefixForProject(ActionRequest request, ActionResponse response) {
		System.out.println("CAll controller for get default prefix::");
		return projectService.getPrefixForProject();
	}

}
