package com.splenta.hrms.controller.masters;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.EmployeeRole;

import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/emploeerole")
@Tag(name = "Emploee Role", description = "APIs for emploeerole related operations")
public class EmployeeRoleController extends GenericController<EmployeeRole> {

	public EmployeeRoleController(GenericRepository<EmployeeRole> repository) {
		super(repository);
	}

}
