package com.axelor.project.module;

import com.axelor.app.AxelorModule;
import com.axelor.project.service.ProjectService;
import com.axelor.project.service.impl.ProjectServiceImpl;

public class ProjectModule extends AxelorModule {
	@Override
	protected void configure() {
		bind(ProjectService.class).to(ProjectServiceImpl.class);

	}

}
