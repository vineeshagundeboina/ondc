package com.splenta.hrms.controller.masters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Domain;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/domain")
@Tag(name = "Domain", description = "APIs for Domain related operations")
public class DomainController extends GenericController<Domain> {

	public DomainController(GenericRepository<Domain> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
