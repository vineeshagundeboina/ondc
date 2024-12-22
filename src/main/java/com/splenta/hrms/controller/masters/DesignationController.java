package com.splenta.hrms.controller.masters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Designation;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/designation")
@Tag(name = "Designation", description = "APIs for Designation related operations")
public class DesignationController extends GenericController<Designation>{

	public DesignationController(GenericRepository<Designation> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
