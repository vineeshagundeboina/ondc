package com.splenta.hrms.controller.masters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Project;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/project")
@Tag(name = "Project", description = "APIs for Project related operations")
public class ProjectController extends GenericController<Project> {

	public ProjectController(GenericRepository<Project> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
