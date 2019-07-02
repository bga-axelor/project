package com.axelor.project.service.impl;

import com.axelor.project.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public String getPrefixForProject() {
		return "Axelor-";
	}

}
